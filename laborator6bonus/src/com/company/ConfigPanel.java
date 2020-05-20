package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ColorConvertOp;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JComboBox colorCombo; // the color of the shape
    JLabel colorLabel;

    JLabel toolLabel;
    JComboBox toolCombo; //can be painter or eraser


    JLabel graphLabel; //can be node or edge
    JComboBox graphComponents;
    JSpinner radiusSpinner;
    JLabel radiusLabel;

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

        //create the graphComponents, containing the values: node and edge
        graphLabel=new JLabel("Graph:");
        String[] components={"Node","Edge"};
        graphComponents=new JComboBox(components);
        graphComponents.setSelectedIndex(0);

        //spinnerul for radius of node
        radiusLabel=new JLabel(" Radius: ");
        radiusSpinner=new JSpinner(new SpinnerNumberModel(0,30,100,1));
        radiusSpinner.setValue(30); //default radius


        //add the components in
        add(toolLabel);
        add(toolCombo);
        add(colorLabel);
        add(colorCombo);
        add(graphLabel);
        add(graphComponents);
        add(radiusLabel);
        add(radiusSpinner);
    }








}
