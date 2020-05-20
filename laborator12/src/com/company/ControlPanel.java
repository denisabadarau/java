package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    final MainFrame frame;

    //The ControlPanel will allow the user to specify any class name of a Swing component
    JLabel classLabel;
    JTextField classField;

    //a default text for that component
    JLabel componentLabel;
    JTextField componentField;

    //a button for creating and adding an instance of the specified component to the DesignPanel
    JButton button;

    private final static String newline = "\n";

    public ControlPanel(MainFrame frame)
    {
        this.frame=frame;

        //create the text field to specify any class name
        classLabel=new JLabel("Class name of a Swing component: ");
        classField=new JTextField(10);

        //create default text for that component
        componentLabel=new JLabel("Component: ");
        componentField=new JTextField(10);

        //create the button
        button=new JButton("Create and add an instance");

        //add the components in ControlPAnel
        add(classLabel);
        add(classField);
        add(componentLabel);
        add(componentField);
        add(button);
    }


}
