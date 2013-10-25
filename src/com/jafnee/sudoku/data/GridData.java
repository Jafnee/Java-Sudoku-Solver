/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafnee.sudoku.data;

import java.io.*;
import java.util.*;

/**
 *
 * @author Jafnee
 */
public class GridData {
    char grid[][];
    char test;
    BufferedReader br;
    Scanner myScanner;
    Solver solver;
    
    /**
     *
     */
    public GridData() {
        grid = new char[9][9];
        this.setGrid();
        solver = new Solver();
        solver.setGridData(this);
    }
    
    /**
     *
     */
    public void setGrid() {
        int i,j;
        for (j=0;j<9;j++)
            for (i=0;i<9;i++)
                this.setValue(i,j,' ');
    }
    
    /**
     *
     * @param i
     * @param j
     * @return
     */
    public char getValue(int i, int j) {
                return grid[i][j];
    }

    
    /**
     *
     * @param i
     * @param j
     * @param v
     */
    public void setValue(int i, int j, char v) {
        grid[i][j] = v;       
    }
    
    /**
     *
     */
    public void clearGrid() {
        int i,j;
        for (j=0;j<9;j++)
            for (i=0;i<9;i++)
                grid[i][j] = ' ';
    }
    
    /**
     *
     * @param r
     * @param s
     */
    public void Transfer(int r, String s) {
        int i;
        char c1;
        for (i=0;i<9;i++) {
            c1 = s.charAt(i);
            this.setValue(i, r, c1);
            
        }
    }
    
    /**
     *
     * @param file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void loadGrid(File file) throws FileNotFoundException, IOException {
        br = new BufferedReader(new FileReader(file));
        char c1;
        int j;
        for (j=0;j<9;j++) {            
        String line = br.readLine();
        this.Transfer(j, line);
        }
    }
    
    /**
     *
     * @return
     */
    public Solver getSolver() {
        return solver;
    }
}
