/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafnee.sudoku.graphic;

import com.jafnee.sudoku.data.GridData;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Jafnee
 */
public class GridPanel extends JPanel {
    JLabel[][] gridBoxes;
    GridData gridData;
    
    public GridPanel() {
        gridBoxes = new JLabel[9][9];
        gridData = new GridData();
        this.setLayout(new GridLayout(9,9));
        this.makeGrid();
        this.fillGrid();
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
                gridBoxes[i][j].setOpaque(true);
            }
        }
    }
    
    public void setGridValue(int i, int j, char c) {
        String v = Character.toString(c);
        gridBoxes[i][j].setText(v);
    }
    
    public void colourGrid(int i, int j) {
        if((i / 3 < 1 || i / 3 >= 2) && (j / 3 < 1 || j / 3 >= 2)
                    || (i / 3 >= 1 && i / 3 < 2) && (j / 3 >= 1 && j / 3 < 2)) {
                    gridBoxes[i][j].setBackground(Color.LIGHT_GRAY);
                } else {
                    gridBoxes[i][j].setBackground(Color.WHITE);
                }
    }
    
    public void fillGrid(){
        int i,j;
        char value;
        for (j=0;j<9;j++) {
            for (i=0;i<9;i++) {
                value = gridData.getValue(i, j);
                this.setGridValue(i,j,value);
            }
        }
    }
}
