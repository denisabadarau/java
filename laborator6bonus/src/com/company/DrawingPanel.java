package com.company;
import javax . swing .*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel{

    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    public DrawingPanel(MainFrame frame)
    {
        this.frame = frame;
        createOffscreenImage();
        init();
    }
    public void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    private void init() {
        setPreferredSize(new Dimension(W,H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e)
            {
                drawShape(e.getX(), e.getY());
                repaint();
            }   });
    }
    private void drawShape(int x, int y) {
        String tool=String.valueOf(frame.configPanel.toolCombo.getSelectedItem());


        Random rand=new Random();
        Color color=Color.BLACK;
        Random rnd=new Random();
        String col=String.valueOf(frame.configPanel.colorCombo.getSelectedItem()); //get the string value  from colorCombo(random or black)

        if(tool.equals("Painter")) {
            if (col.equals("Random")) {
                //generate 3 random numbers from 0 to 255 and then use the Color(int,int,int) constructor to create a new Color instance
                int red, green, blue;
                red = rnd.nextInt(255);
                green = rnd.nextInt(255);
                blue = rnd.nextInt(255);
                color = new Color(red, green, blue);

            }
            graphics.setColor(color);

            int radiusNode= (int)frame.configPanel.radiusSpinner.getValue(); //the value from spinner
            String graphComponents = String.valueOf(frame.configPanel.graphComponents.getSelectedItem()); //get the string value from graphCompinents(node or edge)
            if(graphComponents.equals("Node")){
                graphics.fill(new Node(x,y,radiusNode));
            }



        }
        else if(tool.equals("Eraser"))
        {
            //create an white cercle rhat will be my eraser
            color=Color.WHITE;
            graphics.setColor(color);
            graphics.fill(new Cercle(x,y,30));
        }

    }
    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    public void clear()
    {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
        updateUI();
    }
}
