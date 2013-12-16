/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.sudoku.data;

import com.jafnee.data.sudoku.solver.Solver;
import com.jafnee.sudoku.main.Main;
import java.io.*;
import java.util.*;

/**
 *
 * @author Jafnee
 */
public class GridData {
    Main main;
    Solver solver;
    char[][] grid;
    BufferedReader br;
    Scanner myScanner;
    
    public GridData(Main m) {
        main = m;
        solver = new Solver(this);
        
        grid = new char[9][9];
        setupGrid();
    }
    
    public void setupGrid() {
        int i, j;
        for (j = 0; j < 9; j++) {
            for (i = 0; i < 9; i++) {
                this.setValue(i, j, ' ');
            }
        }
    }
    
    public char getValue(int i, int j) {
        return grid[i][j];
    }
    
    public void setValue(int i, int j, char v) {
        grid[i][j] = v;
    }
    
    /**
     * Used to convert the String acquired from loading into a char, to put into
     * the array.
     * @param j The j coordinate of the square.
     * @param s The value that will will go into the square.
     */
    public void transfer(int j, String s) {
        int i;
        char c1;
        for (i = 0; i < 9; i++) {
            c1 = s.charAt(i);
            this.setValue(i, j, c1);

        }
    }
    
    public void loadGrid(File file) throws FileNotFoundException, IOException {
        br = new BufferedReader(new FileReader(file));
        char c1;
        int j;
        for (j = 0; j < 9; j++) {
            String line = br.readLine();
            this.transfer(j, line);
        }
    }
    
    public Main getMain() {
        return main;
    }
    
    public Solver getSolver() {
        return solver;
    }
}
