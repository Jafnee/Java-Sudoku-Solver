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
        //gridData.setValue(6,2,'3');
        this.makeGrid();
        System.out.println("made it before fill");
        this.fillGrid();
        System.out.println("made it after fill");        
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
                this.add(gridBoxes[i][j]);
            }
        }
    }
    
    public void setGridValue(int i, int j, char c) {
        String v = Character.toString(c);
        gridBoxes[i][j].setText(v);
        
    }
    
    public void fillGrid(){
        int i,j;
        char value;
        System.out.println("made it to start of fill");
        for (j=0;j<9;j++) {
            for (i=0;i<9;i++) {
                System.out.println("made it to start of fill part 2");
                value = gridData.getValue(i, j);
                System.out.println("made it to mid of fill");
                this.setGridValue(i,j,value);
            }
        }
    }
    
    public void test() {
        System.out.println("IT WORKS!");
    }
}
