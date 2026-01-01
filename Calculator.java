import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculator extends javax.swing.JFrame {

    private double firstNumber = 0;
    private String operator = "";
    private boolean isNewNumber = true;

    public Calculator() {
        initComponents();
        setTitle("Kalkulator Pro");
        setLocationRelativeTo(null); // Agar muncul di tengah layar
    }

    private void inputNumber(String number) {
        if (jTextField1.getText().equals("0") || isNewNumber) {
            jTextField1.setText(number);
            isNewNumber = false;
        } else {
            jTextField1.setText(jTextField1.getText() + number);
        }
    }

    private void setOperator(String op) {
        firstNumber = Double.parseDouble(jTextField1.getText());
        operator = op;
        isNewNumber = true;
    }

    private void calculate() {
        double secondNumber = Double.parseDouble(jTextField1.getText());
        double result = 0;

        switch (operator) {
            case "+" -> result = firstNumber + secondNumber;
            case "-" -> result = firstNumber - secondNumber;
            case "x" -> result = firstNumber * secondNumber;
            case "/" -> result = secondNumber != 0 ? firstNumber / secondNumber : 0;
            case "%" -> result = firstNumber % secondNumber;
        }

        jTextField1.setText(String.valueOf(result));
        isNewNumber = true;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        // Tombol Angka 
        jButton1 = new javax.swing.JButton("<");
        jButton2 = new javax.swing.JButton("7");
        jButton3 = new javax.swing.JButton("8");
        jButton4 = new javax.swing.JButton("9");
        jButton5 = new javax.swing.JButton("+");
        jButton6 = new javax.swing.JButton("4");
        jButton7 = new javax.swing.JButton("5");
        jButton8 = new javax.swing.JButton("6");
        jButton9 = new javax.swing.JButton("-");
        jButton10 = new javax.swing.JButton("1");
        jButton11 = new javax.swing.JButton("2");
        jButton12 = new javax.swing.JButton("3");
        jButton13 = new javax.swing.JButton("x");
        jButton14 = new javax.swing.JButton("0");
        jButton15 = new javax.swing.JButton(".");
        jButton16 = new javax.swing.JButton("=");
        jButton17 = new javax.swing.JButton("/");
        jButton18 = new javax.swing.JButton("C");

        // 
        btnPangkat2 = new javax.swing.JButton("x²");
        btnPangkat3 = new javax.swing.JButton("x³");
        btnAkar = new javax.swing.JButton("√");
        btnPersen = new javax.swing.JButton("%");
        btnModulo = new javax.swing.JButton("Mod");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setText("0");
        jTextField1.setFont(new Font("Arial", Font.BOLD, 18));

        
        jButton1.addActionListener(evt -> {
            String text = jTextField1.getText();
            if (text.length() > 1) jTextField1.setText(text.substring(0, text.length() - 1));
            else jTextField1.setText("0");
        });
        jButton2.addActionListener(evt -> inputNumber("7"));
        jButton3.addActionListener(evt -> inputNumber("8"));
        jButton4.addActionListener(evt -> inputNumber("9"));
        jButton5.addActionListener(evt -> setOperator("+"));
        jButton6.addActionListener(evt -> inputNumber("4"));
        jButton7.addActionListener(evt -> inputNumber("5"));
        jButton8.addActionListener(evt -> inputNumber("6"));
        jButton9.addActionListener(evt -> setOperator("-"));
        jButton10.addActionListener(evt -> inputNumber("1"));
        jButton11.addActionListener(evt -> inputNumber("2"));
        jButton12.addActionListener(evt -> inputNumber("3"));
        jButton13.addActionListener(evt -> setOperator("x"));
        jButton14.addActionListener(evt -> inputNumber("0"));
        jButton15.addActionListener(evt -> { if(!jTextField1.getText().contains(".")) jTextField1.setText(jTextField1.getText() + "."); });
        jButton16.addActionListener(evt -> calculate());
        jButton17.addActionListener(evt -> setOperator("/"));
        jButton18.addActionListener(evt -> { jTextField1.setText("0"); firstNumber = 0; operator = ""; isNewNumber = true; });

        // Event Listeners Fungsi Baru
        btnPangkat2.addActionListener(evt -> {
            double val = Double.parseDouble(jTextField1.getText());
            jTextField1.setText(String.valueOf(val * val));
            isNewNumber = true;
        });
        btnPangkat3.addActionListener(evt -> {
            double val = Double.parseDouble(jTextField1.getText());
            jTextField1.setText(String.valueOf(val * val * val));
            isNewNumber = true;
        });
        btnAkar.addActionListener(evt -> {
            double val = Double.parseDouble(jTextField1.getText());
            jTextField1.setText(String.valueOf(Math.sqrt(val)));
            isNewNumber = true;
        });
        btnPersen.addActionListener(evt -> {
            double val = Double.parseDouble(jTextField1.getText());
            jTextField1.setText(String.valueOf(val / 100));
            isNewNumber = true;
        });
        btnModulo.addActionListener(evt -> setOperator("%"));

        // Layouting 
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 5, 5)); // 6 baris, 4 kolom

        panel.add(jButton18); panel.add(btnAkar);   panel.add(btnPersen); panel.add(jButton1);
        panel.add(btnPangkat2); panel.add(btnPangkat3); panel.add(btnModulo); panel.add(jButton17);
        panel.add(jButton2);  panel.add(jButton3);  panel.add(jButton4);  panel.add(jButton13);
        panel.add(jButton6);  panel.add(jButton7);  panel.add(jButton8);  panel.add(jButton9);
        panel.add(jButton10); panel.add(jButton11); panel.add(jButton12); panel.add(jButton5);
        panel.add(jButton14); panel.add(jButton15); panel.add(new JLabel("")); panel.add(jButton16);

        getContentPane().setLayout(new BorderLayout(10, 10));
        getContentPane().add(jTextField1, BorderLayout.NORTH);
        getContentPane().add(panel, BorderLayout.CENTER);

        pack();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Calculator().setVisible(true));
    }

    // Variabel declaration
    private javax.swing.JButton jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9,
            jButton10, jButton11, jButton12, jButton13, jButton14, jButton15, jButton16, jButton17, jButton18;
    private javax.swing.JButton btnPangkat2, btnPangkat3, btnAkar, btnPersen, btnModulo;
    private javax.swing.JTextField jTextField1;
}