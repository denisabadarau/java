package com.company;


import java.io.*;
import java.awt.*;

public class CatalogUtil {

    public static void save(Catalog catalog)
    {
        try
        {
            FileOutputStream file=new FileOutputStream(catalog.getPath());
            ObjectOutputStream out=new ObjectOutputStream(file);
            out.writeObject(catalog);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Catalog load(String path)
    {
        try
        {
            FileInputStream file=new FileInputStream(path);
            ObjectInputStream in=new ObjectInputStream(file);
            Catalog catalog=(Catalog)in.readObject();
            return catalog;
        }catch(IOException e)
        {
            e.printStackTrace();
        }catch(ClassNotFoundException e)
        {
            System.out.println("Catalog class not found");
            e.printStackTrace();
        }
        return null;
    }

    public static void view(Document doc)
    {
        Desktop desktop=Desktop.getDesktop(); //the Desktop instance of the current browser context
        File file=new File(doc.getLocation());
        try
        {
            desktop.open(file);
        }catch(IOException e)
        {
            e.printStackTrace();
        }


    }

}