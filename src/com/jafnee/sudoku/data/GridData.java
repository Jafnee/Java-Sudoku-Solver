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
    char grid[][],temps[][];
    char test;
    BufferedReader br;
    Scanner myScanner;
    
    public GridData() {
        grid = new char[9][9];
        this.setGrid();
        temps = new char [81][81];
        System.out.println("got to before set grid");
        System.out.println("got to after set grid");
    }
    
    public void setGrid() {
        int i,j;
        for (j=0;j<9;j++)
            for (i=0;i<9;i++)
                grid[i][j] = ' ';
    }
    
    public char getTest() {
        return test;
    }
    
    public char getValue(int i, int j) {
                return grid[i][j];
    }

    
    public void setValue(int i, int j, char v) {
        grid[i][j] = v;       
    }
    
    public void clearGrid() {
        int i,j;
        for (j=0;j<9;j++)
            for (i=0;i<9;i++)
                grid[i][j] = ' ';
    }
    
    public char getTempsValue(int i, int j) {
        return temps[i][j];
    }
    
    public void setTempsValue(int i, int j, char v) {
        temps[i][j] = v;
    }
    
    public void Transfer(int r, String s) {
        int i;
        char c1;
        for (i=0;i<9;i++) {
            c1 = s.charAt(i);
            this.setValue(i, r, c1);
            
        }
    }
    
    public void loadGrid(File file) throws FileNotFoundException, IOException {
        br = new BufferedReader(new FileReader(file));
        char c1;
        int j;
        for (j=0;j<9;j++) {            
        String line = br.readLine();
        this.Transfer(j, line);
        }

    }
}
