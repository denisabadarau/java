package com.company;
import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame{
    ConfigPanel configPanel;
    DrawingPanel canvas;
    ControlPanel controlPanel;

    public MainFrame(String title)
    {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        configPanel=new ConfigPanel(this);
        controlPanel=new ControlPanel(this);
        canvas=new DrawingPanel(this);

        getContentPane().setLayout(new BorderLayout());

        //arrange the components in the container (frame)
        add(configPanel,BorderLayout.NORTH); // TOP
        add(canvas,BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH); //BOTTOM

        pack();

    }
}
