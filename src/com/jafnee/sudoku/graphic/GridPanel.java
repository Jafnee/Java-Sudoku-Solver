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

/**This JPanel will visually present the Sudoku grid to the user.
 * 
 *
 * @author Jafnee Jesmee
 * @version 25/10/2013
 */
public class GridPanel extends JPanel {
    JLabel[][] gridBoxes;
    GridData gridData;
    
    /**
     * The default constructor initialises the JLabel 2D array.
     * The 2D array will contain and display the value of the square.
     * It also will executes the methods needed to make the Sudoku grid visible.
     */
    public GridPanel() {
        gridBoxes = new JLabel[9][9];
        gridData = new GridData();
        this.setLayout(new GridLayout(9,9));
        this.makeGrid();
        this.fillGrid();
    }
    
    /**
     * This method will create a 9x9 grid of blanks.
     */
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
    
    /**Method to set the value of a specific JLabel
     * 
     * @param i i coordinate
     * @param j j coordinate
     * @param c char value 
     */
    public void setGridValue(int i, int j, char c) {
        String v = Character.toString(c);
        gridBoxes[i][j].setText(v);
    }
    
    /**Colour coordinates the grid by each 3x3 sub-grid; makes it easier to the user to navigate visually.
     * 
     * @param i i coordinate
     * @param j j coordinate
     */
    public void colourGrid(int i, int j) {
        if((i / 3 < 1 || i / 3 >= 2) && (j / 3 < 1 || j / 3 >= 2)
                    || (i / 3 >= 1 && i / 3 < 2) && (j / 3 >= 1 && j / 3 < 2)) {
                    gridBoxes[i][j].setBackground(Color.LIGHT_GRAY);
                } else {
                    gridBoxes[i][j].setBackground(Color.WHITE);
                }
        gridBoxes[i][j].setOpaque(true);
    }
    
    /**
     * This method will transfer the values of the grid[][] array from the GridData class into the JLabels.
     */
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
