/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.graphic;

/**
 *
 * @author Jafnee
 */
public class ContainerPanel {
    private ButtonPanel buttonPanel;
    private GridPanel gridPanel;
    
    public ContainerPanel() {
        gridPanel = new GridPanel();
        buttonPanel = new ButtonPanel();
    }
    
    public void createPanel() {
        
    }
}
