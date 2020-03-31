package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
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
        /* compulsory
        try
        {
            BufferedImage image=ImageIO.read(new File("C:\\Users\\denis\\Desktop\\java\\laborator6FINAL/test.png"));
            frame.canvas.graphics.drawImage(image,0,0,this);

        }catch(IOException ex){System.err.println(ex);}

         */

        /*optional: using a file chooser*/

        try
        {
            JFileChooser file=new JFileChooser();
            file.setDialogTitle("Choose a directory to load your file: ");

            int returnValue=file.showOpenDialog(null);

            if(returnValue == JFileChooser.APPROVE_OPTION)
            {
                //getting the file that was selected
                File myFile=file.getSelectedFile();
                //getting the image from that file
                BufferedImage image=ImageIO.read(new File(myFile.getAbsolutePath()));
                frame.canvas.graphics.drawImage(image,0,0,this);
            }
        }catch(IOException ex){System.err.println(ex);}

    }

    private void save(ActionEvent e)
    {
        /* compulsory
        try
        {
            ImageIO.write(frame.canvas.image, "PNG", new File("C:\\Users\\denis\\Desktop\\java\\laborator6FINAL/test.png"));
        } catch (IOException ex) { System.err.println(ex); }

         */
        /*optional: usign a file chooser in order to specify the file where image will be saved */

        try {
            JFileChooser file = new JFileChooser();
            file.setDialogTitle("Choose a directory to save your file: ");

            int returnValue = file.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                //getting the file that was selected
                File myFile = file.getSelectedFile();
                //saving the image in the file
                ImageIO.write(frame.canvas.image, "PNG", new File(myFile.getAbsolutePath()));
            }
        }catch (IOException ex) { System.err.println(ex); }

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
