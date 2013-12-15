/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.graphic;

import javax.swing.JPanel;

/**
 *
 * @author Jafnee
 */
public class ContainerPanel extends JPanel {
    private final ButtonPanel buttonPanel;
    private final GridPanel gridPanel;
    private JPanel panel;
    
    public ContainerPanel() {
        gridPanel = new GridPanel();
        buttonPanel = new ButtonPanel();
    }
    
    public void createPanel() {
        panel = new JPanel();
    }
}
