/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.sudoku.graphic;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Jafnee
 */
public class GridView extends JPanel {
    ContainerPanel containerPanel;
    JLabel[][] gridView;
    
    public GridView(ContainerPanel cp) {
        containerPanel = cp;
        
        gridView = new JLabel[9][9];
        this.setLayout(new GridLayout(9,9));
        this.makeGrid();
    }
    
    public void makeGrid() {
        int i,j;
   
        
        for (j=0;j<9;j++) {
            for (i=0;i<9;i++) {
                gridView[i][j] = new JLabel();
                gridView[i][j].setText(" ");
                gridView[i][j].setVerticalAlignment(JLabel.CENTER);
                gridView[i][j].setHorizontalAlignment(JLabel.CENTER);
                gridView[i][j].setFont(gridView[i][j].getFont().deriveFont(39.0f));
                Border border = BorderFactory.createLineBorder(Color.BLACK,1);
                gridView[i][j].setBorder(border);
                this.colourGrid(i, j);
                this.add(gridView[i][j]);
            }
        }
    }
    
    public void colourGrid(int i, int j) {
        if((i / 3 < 1 || i / 3 >= 2) && (j / 3 < 1 || j / 3 >= 2)
                    || (i / 3 >= 1 && i / 3 < 2) && (j / 3 >= 1 && j / 3 < 2)) {
                    gridView[i][j].setBackground(Color.LIGHT_GRAY);
                } else {
                    gridView[i][j].setBackground(Color.WHITE);
                }
        gridView[i][j].setOpaque(true);
    }
    
    public void fillGrid(){
        int i,j;
        char value;
        for (j=0;j<9;j++) {
            for (i=0;i<9;i++) {
                value = containerPanel.getMainFrame().getMain().getGridModel().getValue(i, j);
                setGridValue(i, j, value);
            }
        }
    }
    
    public void setGridValue(int i, int j, char c) {
        String v = Character.toString(c);
        gridView[i][j].setText(v);
    }
}
