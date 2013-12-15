/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafnee.sudoku.data;

/**This class contains all the methods required a Sudoku puzzle.
 * It will interact with the GridData class to get the solving completed.
 *
 * @author Jafnee Jafnee
 * @version 25/10/2013
 */
public class Solver {
//    char[] solutions;
    char[][][] solutions;
    
    GridData grid;
    int changes;
    boolean solved;
    
    public Solver () {
        solutions = new char[9][9][9];
    }
    
    
   
    public void fillInitialSolutions() {
        for (int j = 0 ; j < 9 ; j++) {
            for (int i = 0 ; i < 9 ; i++) {
                for(int n = 0 ; n < 9 ; n++) {
                    setSolution(i, j, n,'T');
                }
            }
        }
    }
    
    public void setSolution(int i, int j, int n, char v) {
        solutions[i][j][n] = v;
    }
    
    public char getSolution(int i, int j, int n) {
        return solutions[i][j][n];
    }
    
    public void solve() {
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
                    fillInitialSolutions();                    
                    this.rowCompare(j);
                    this.columnCompare(i);
                    this.fillDefinite();
                    
                }
            }
        }
       this.changesLoop();
       this.hasBeenSolved();
    }
    
    
    public void hasBeenSolved() {
        int i, j;
        for (j=0;j<9;j++) {
           for (i=0;i<9;i++) {
               if (this.getGridData().getValue(i, j) == ' ') {
                   this.setSolved(false);
               }
           }
        }
    }
    
    
    public void changesLoop() {
        if (changes !=0) {
            this.solve();
        }
    }
    
    public void fillDefinite() {
        char definiteSolution = 0;
        for (int j = 0 ; j < 9 ; j++) {
            for (int i = 0 ; i < 9 ; i ++) {
                int noSolutions = 0;
                for (int n = 0 ; n <9 ; n++) {
                    if (getSolution(i,j,n) == 'T') {
                        noSolutions++;
                        definiteSolution = getSolution(i,j,n);
                    }
                }
                if (noSolutions == 1) {
                    grid.setValue(i, j, definiteSolution);
                }
            }
        }
    }
 
//    public void fillDefinite(int i, int j) {
//        int x,numberOfSolutions;
//        char v,solution;
//        solution = 'X';
//        numberOfSolutions = 0;
//        for (x=0;x<9;x++) {
//            v = this.getSolution(x);
//            if (v != 'X') {
//                solution = v;
//                numberOfSolutions++;
//            }
//        }
//        if (numberOfSolutions == 1) {
//                grid.setValue(i, j, solution);
//                changes++;
//            }
//        System.out.println("POSSIBLE SOLUTIONS FOR Grid ["+i+","+j+"]");//Shows the possible solution(s) each square can have
//        for (int z=0;z<9;z++) {
//            if (this.getSolution(z) != 'X') {
//            System.out.println(this.getSolution(z));
//            }
//        }
//    }
   
    
    
    
    public void columnCompare(int i) {
        int j, s;        
        for (j=0;j<9;j++) {
            for (s=0;s<9;s++) {
            if (this.getGridData().getValue(i, j) == this.getSolution(i,j,s)) { // if value is equal to j in solution array
                this.setSolution(i,j,s,'F'); // set solution j to 'X'
                }
            }
        }
    }
    
   
    public void rowCompare(int j) {
        int i, s;
        for (i=0;i<9;i++) {
            for (s=0;s<9;s++) {
            if (this.getGridData().getValue(i, j) == this.getSolution(i,j,s)) {
                this.setSolution(i,j,s, 'F');
                }
            }
        }
    }
    
    
//    public void fillSolutions() {
//        int i,i2;
//        char v;
//        for (i=0;i<9;i++) {
//            i2 = i + 1;
//            v = Character.forDigit(i2,10);
//            this.setSolutions(i, v);
//        }
//    }
        
    
   
    
    public void setGridData(GridData gd) {
        grid = gd;
    }
    
    public GridData getGridData() {
        return grid;
    }
    
    /**This method set's the variable to set whether the puzzle has been solved completely.
     * 
     * @param b boolean value to set for solved
     */
    public void setSolved(boolean b) {
        solved = b;
    }
    
    /**This method returns the boolean value of solved, to determine if the puzzle has been solved completely.
     * 
     * @return boolean value of solved
     */
    public boolean getSolved() {
        return solved;
    }

}
