/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.graphic;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Jafnee
 */
public class GridPanel extends JPanel {
    ContainerPanel containerPanel;
    JLabel[][] gridBoxes;
    
    public GridPanel(ContainerPanel cp) {
        containerPanel = cp;
        
        gridBoxes = new JLabel[9][9];
        this.setLayout(new GridLayout(9,9));
        this.makeGrid();
        //this.fillGrid();
    }
    
    public void makeGrid() {
        int i,j;
        for (j=0;j<9;j++) {
            for (i=0;i<9;i++) {
                gridBoxes[i][j] = new JLabel();
                gridBoxes[i][j].setText(" ");
                gridBoxes[i][j].setVerticalAlignment(JLabel.CENTER);
                gridBoxes[i][j].setHorizontalAlignment(JLabel.CENTER);
                gridBoxes[i][j].setFont(gridBoxes[i][j].getFont().deriveFont(39.0f));
                Border border = BorderFactory.createLineBorder(Color.BLACK,1);
                gridBoxes[i][j].setBorder(border);
                this.colourGrid(i, j);
                this.add(gridBoxes[i][j]);
            }
        }
    }
    
    public void colourGrid(int i, int j) {
        if((i / 3 < 1 || i / 3 >= 2) && (j / 3 < 1 || j / 3 >= 2)
                    || (i / 3 >= 1 && i / 3 < 2) && (j / 3 >= 1 && j / 3 < 2)) {
                    gridBoxes[i][j].setBackground(Color.LIGHT_GRAY);
                } else {
                    gridBoxes[i][j].setBackground(Color.WHITE);
                }
        gridBoxes[i][j].setOpaque(true);
    }
}
