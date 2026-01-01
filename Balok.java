/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PewarisanInheritance;

/**
 *
 * @author nabil
 */
public class Balok extends BangunRuang {
    double p, l, t;

    public Balok(double p, double l, double t) {
        this.p = p;
        this.l = l;
        this.t = t;
    }

    @Override
    public double volume() {
        return p * l * t;
    }
}