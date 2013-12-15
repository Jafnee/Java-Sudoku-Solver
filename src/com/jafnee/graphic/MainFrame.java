/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.graphic;

import com.jafnee.main.Start;
import javax.swing.JFrame;

/**
 *
 * @author Jafnee
 */
public class MainFrame extends JFrame{
    private ContainerPanel containerPanel;
    
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        containerPanel = new ContainerPanel();
        this.add(containerPanel);
        this.setSize(600, 600);
        this.setResizable(false);
        this.setVisible(true);
    }
}
