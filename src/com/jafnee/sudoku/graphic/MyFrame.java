/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafnee.sudoku.graphic;

import javax.swing.*;

/**
 *
 * @author Jafnee
 */
public class MyFrame extends JFrame {
    private ContainerPanel container;
        
    public MyFrame() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        container = new ContainerPanel();
        this.add(container);         
        this.setSize(600,600);
        this.setVisible(true);                    
    }
    
    
}

