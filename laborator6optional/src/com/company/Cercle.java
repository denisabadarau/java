package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Cercle extends Ellipse2D.Double {
    public Cercle(double x0, double y0, double radius) {
        super(x0 - radius , y0 - radius , radius*2, radius*2);
    }
}