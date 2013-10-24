/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafnee.sudoku.data;

import java.io.*;

/**
 *
 * @author Jafnee
 */
public class GridData {
    char grid[][],temps[][];
    char test;
    BufferedReader br;
    
    public GridData() {
        grid = new char[9][9];
        this.setGrid();
        temps = new char [81][81];
        test = '8';
        this.setValue(3, 7, test);
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
    
    public void loadGrid(File file) throws FileNotFoundException, IOException {
        br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        while (line != null) {
        System.out.println("loadGrid will load from"+file);
            
        }

    }
}
