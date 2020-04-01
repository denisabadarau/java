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
    JLabel toolLabel;
    JComboBox toolCombo; //can be painter or eraser

    public ConfigPanel(MainFrame frame)
    {
        this.frame=frame;

        //create the toolCombo
        toolLabel=new JLabel("Tool: ");
        String[] tools={"Painter", "Eraser"};
        toolCombo=new JComboBox(tools);
        toolCombo.setSelectedIndex(0);

        //create the colorCombo, containing the values: Random and Black
        colorLabel=new JLabel("Color: ");
        String[] colors={"Random", "Black"};
        colorCombo=new JComboBox(colors);
        colorCombo.setSelectedIndex(0);

        //create the listOfShapes, containing the values: circle, triangle, hexagon,square, oval
        shapesLabel=new JLabel("Shapes:");
        String[] shapes={"Circle","Triangle","Hexagon","Square","Oval"};
        listOfShapes=new JComboBox(shapes);
        listOfShapes.setSelectedIndex(0);


        //add the components in
        add(toolLabel);
        add(toolCombo);
        add(colorLabel);
        add(colorCombo);
        add(shapesLabel);
        add(listOfShapes);
    }








}
