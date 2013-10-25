/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafnee.sudoku.data;

import java.io.*;
import java.util.*;

/**
 * This class is where all the Sudoku values will be loaded into and manipulated
 * from.
 *
 * @author Jafnee Jesmee
 * @version 25/10/2013
 */
public class GridData {

    char grid[][];
    char test;
    BufferedReader br;
    Scanner myScanner;
    Solver solver;

    /**
     * The constructor will initialise the 2D array of type char and fill it's
     * values with blanks. The object solver of the Solver class will also be
     * initialised to link the GridData and Solver classes together; allowing
     * for GridData to call Solver methods and vice-versa.
     *
     */
    public GridData() {
        grid = new char[9][9];
        this.setupGrid();
        solver = new Solver();
        solver.setGridData(this);
    }

    /**
     * Method to initially fill the grid array with blanks.
     *
     */
    public void setupGrid() {
        int i, j;
        for (j = 0; j < 9; j++) {
            for (i = 0; i < 9; i++) {
                this.setValue(i, j, ' ');
            }
        }
    }

    /**
     * Returns the char value of a specific element in the char array.
     *
     * @param i i coordinate
     * @param j j coordinate
     * @return char value returned
     */
    public char getValue(int i, int j) {
        return grid[i][j];
    }

    /**
     * Sets the value of a specific element in the char array.
     *
     * @param i i coordinate
     * @param j j coordinate
     * @param v char value to input
     */
    public void setValue(int i, int j, char v) {
        grid[i][j] = v;
    }

    /**
     * Transfers values loaded from the .SUD file line by line into the char
     * array. .charAt() was used to extract specific characters from the line.
     *
     * @param j j coordinate
     * @param s A line from the .SUD file.
     */
    public void transfer(int j, String s) {
        int i;
        char c1;
        for (i = 0; i < 9; i++) {
            c1 = s.charAt(i);
            this.setValue(i, j, c1);

        }
    }

    /**
     * Loads the .SUD file and stores a line of it to be used by transfer() method
     *
     * @param file is the .SUD file chosen by the user to be loaded.
     * 
     */
    public void loadGrid(File file) throws FileNotFoundException, IOException {
        br = new BufferedReader(new FileReader(file));
        char c1;
        int j;
        for (j = 0; j < 9; j++) {
            String line = br.readLine();
            this.transfer(j, line);
        }
    }
   
    public Solver getSolver() {
        return solver;
    }
}
