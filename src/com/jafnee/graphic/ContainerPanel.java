/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.graphic;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Jafnee
 */
public class ContainerPanel extends JPanel {
    private final ButtonPanel buttonPanel;
    private final GridPanel gridPanel;
    MainFrame mainFrame;
    
    public ContainerPanel(MainFrame mf) {
        mainFrame = mf;
        gridPanel = new GridPanel(this);
        buttonPanel = new ButtonPanel(this);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        this.add(buttonPanel, c);
        
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 5.5;
        c.weighty = 5.5;
        c.gridx = 0;
        c.gridy = 1;
        this.add(gridPanel, c);
    }
    
    public void createPanel() {
        
    }
}
