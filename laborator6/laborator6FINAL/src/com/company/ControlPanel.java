package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadButton=new JButton("Load");
    JButton saveButton=new JButton("Save");
    JButton resetButton=new JButton("Reset");
    JButton exitButton=new JButton("Exit");

    public ControlPanel(MainFrame frame)
    {
        this.frame=frame;
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        //add all buttons
        add(loadButton);
        add(saveButton);
        add(resetButton);
        add(exitButton);

        //configure listeners for all buttons
        loadButton.addActionListener(this::load);
        saveButton.addActionListener(this::save);
        resetButton.addActionListener(this::reset);
        exitButton.addActionListener(this::exit);

    }

    private void load(ActionEvent e)
    {
        try
        {
            BufferedImage image=ImageIO.read(new File("C:\\Users\\denis\\Desktop\\java\\laborator6/test.png"));
            frame.canvas.graphics.drawImage(image,0,0,this);

        }catch(IOException ex){System.err.println(ex);}

    }

    private void save(ActionEvent e)
    {
        try
        {
            ImageIO.write(frame.canvas.image, "PNG", new File("C:\\Users\\denis\\Desktop\\java\\laborator6/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e)
    {
        frame.canvas.clear();
    }

    private void exit(ActionEvent e)
    {
        System.exit(0);
    }
}
