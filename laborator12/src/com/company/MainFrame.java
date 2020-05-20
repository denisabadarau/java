package com.company;

import javax.swing.*;
import java.awt.*;
/*Create the class MainFrame of type JFrame.
The frame will contain a ControlPanel in the north
and a DesignPanel in the center.*/
public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;

    public MainFrame(String title)
    {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        controlPanel=new ControlPanel(this);
        designPanel=new DesignPanel(this);

        getContentPane().setLayout(new BorderLayout());

        //arrange the components in the container (frame)
        add(controlPanel,BorderLayout.NORTH);
        add(designPanel,BorderLayout.CENTER);

        pack();
    }

}
