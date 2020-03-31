package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ColorConvertOp;
import java.util.Random;

public class ConfigPanel extends JPanel {
   final MainFrame frame;
    JComboBox colorCombo; // the color of the shape
    JLabel colorLabel;
    JComboBox listOfShapes; // list of available shapes
    JLabel shapesLabel;

    public ConfigPanel(MainFrame frame)
    {
        this.frame=frame;

        //create the colorCombo, containing the values: Random and Black
        colorLabel=new JLabel("Color: ");
        String[] colors={"Random", "Black"};
        colorCombo=new JComboBox(colors);
        colorCombo.setSelectedIndex(0);

        //create the listOfShapes, containing the values: cercle, triangle, hexagon,square, oval
        shapesLabel=new JLabel("Shapes:");
        String[] shapes={"Cercle","Triangle","Hexagon","Square","Oval"};
        listOfShapes=new JComboBox(shapes);
        listOfShapes.setSelectedIndex(0);


        //add the components in configPanel
        add(colorLabel);
        add(colorCombo);
        add(shapesLabel);
        add(listOfShapes);
    }








}
