/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafnee.sudoku.graphic;

import javax.swing.*;

/**The class creates the JFrame which will contain the panels used to display the user interface.
 *
 * @author Jafnee Jesmee
 * @version 25/10/2013
 */
public class MyFrame extends JFrame {
    private ContainerPanel container;
    /**
     * The default constructor will create the JFrame to the dimensions specified and will add the ContainerPanel into it
     * which will contain the graphical components the user will interact with.
     * 
     */    
    public MyFrame() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        container = new ContainerPanel();
        container.setMyFrame(this);
        this.add(container);
        this.setSize(600,600);//The minimum resolution of the user is assumed to be 800x600.
        this.setResizable(false);//Prevents the user from altering the dimensions of the frame.
        this.setVisible(true);   
        this.setTitle("File loaded: No file loaded");
    }
}

