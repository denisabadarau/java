package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Oval extends Ellipse2D.Double {
    public Oval(double x0, double y0, double radius) {
        super(x0 - radius , y0 - radius , radius, radius*2);
    }
}