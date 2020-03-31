package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ColorConvertOp;
import java.util.Random;

public class ConfigPanel extends JPanel {
   final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JSpinner numberOfSides; // number of sides
    JComboBox colorCombo; // the color of the shape
    JLabel colorLabel;

    public ConfigPanel(MainFrame frame)
    {
        this.frame=frame;

        //create the label and the spinner
        label=new JLabel(" Number of sides: ");
        numberOfSides=new JSpinner(new SpinnerNumberModel(0,0,100,1));
        numberOfSides.setValue(6); //default number of sides

        //create the colorCombo, containing the values: Random and Black
        colorLabel=new JLabel("Color: ");
        String[] colors={"Random", "Black"};
        colorCombo=new JComboBox(colors);
        colorCombo.setSelectedIndex(0);

        //add the components in configPanel
        add(label);
        add(numberOfSides);
        add(colorLabel);
        add(colorCombo);
    }








}
