/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafnee.sudoku.data;

import javax.swing.JOptionPane;

/**
 *
 * @author Jafnee
 */
public class Solver {
    char[] solutions;
    char[][][] storedSolutions;
    GridData grid;
    int changes;
    boolean solved;
    
    public Solver () {
       storedSolutions = new char[9][9][9];
    }
    
    public void Solve() {
         int i,j;
         char value;
         changes = 0;
         this.setSolved(true);
       for (j=0;j<9;j++) {
            for (i=0;i<9;i++) {
                value = this.getGridData().getValue(i, j);
                if (value != ' ') {
                }
                else {
                    solutions = new char[9];
                    this.fillSolutions();
                    this.ownSubGridCompare(i, j);
                    this.rowCompare(j);
                    this.columnCompare(i);
                    this.fillDefinite(i, j);
                    
                }
            }
        }
       if (changes != 0) {
           this.Solve();
       }
       for (j=0;j<9;j++) {
           for (i=0;i<9;i++) {
               if (this.getGridData().getValue(i, j) == ' ') {
                   this.setSolved(false);
               }
           }
       }
    }
    
    public void fillDefinite(int i, int j) {
        int x,numberOfSolutions;
        char v,solution;
        solution = 'X';
        numberOfSolutions = 0;
        for (x=0;x<9;x++) {
            v = this.getSolution(x);
            if (v != 'X') {
                solution = v;
                numberOfSolutions++;
            }
        }
        if (numberOfSolutions == 1) {
                grid.setValue(i, j, solution);
                changes++;
            }
        System.out.println("POSSIBLE SOLUTIONS FOR Grid ["+i+","+j+"]");
        for (int z=0;z<9;z++) {
            if (this.getSolution(z) != 'X') {
            System.out.println(this.getSolution(z));
            }
        }
    }
    
    public void ownSubGridCompare(int i, int j) {
        int tempI, tempI2, tempI3, tempJ, tempJ2, tempJ3, s;
        tempI = i/3;
        tempI2 = tempI*3;
        tempI3 = tempI2 + 3;
        tempJ = j/3;
        tempJ2 = tempJ*3;
        tempJ3 = tempJ2 + 3;
        for (tempJ2=tempJ*3;tempJ2<tempJ3;tempJ2++) {
            for (tempI2 = tempI*3;tempJ2<tempJ3;tempJ2++) {
                for (s=0;s<9;s++) {
                    if (this.getGridData().getValue(tempI2, tempJ2) == this.getSolution(s)) { 
                    this.setSolutions(s, 'X');
                    }
                }
            }
        }
    }
    
    public void columnCompare(int i) {
        int j, s;        
        for (j=0;j<9;j++) {
            for (s=0;s<9;s++) {
            if (this.getGridData().getValue(i, j) == this.getSolution(s)) { // if value is equal to j in solution array
                this.setSolutions(s, 'X'); // set solution j to 'X'
                }
            }
        }
    }
    
    public void rowCompare(int j) {
        int i, s;
        for (i=0;i<9;i++) {
            for (s=0;s<9;s++) {
            if (this.getGridData().getValue(i, j) == this.getSolution(s)) {
                this.setSolutions(s, 'X');
                }
            }
        }
    }
    
    public void fillSolutions() {
        int i,i2;
        char v;
        for (i=0;i<9;i++) {
            i2 = i + 1;
            v = Character.forDigit(i2,10);
            this.setSolutions(i, v);
        }
    }
    
    public void setSolutions(int i, char v) {
        solutions[i] = v;
    }
    
    public char getSolution(int i) {
        return solutions[i];
    }
    
    public void rowFill() {
        
    }
    
    public void setGridData(GridData gd) {
        grid = gd;
    }
    
    public GridData getGridData() {
        return grid;
    }
    
    public void setSolved(boolean b) {
        solved = b;
    }
    
    public boolean getSolved() {
        return solved;
    }

}
