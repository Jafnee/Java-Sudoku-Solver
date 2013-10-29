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
    char[] solutions;
    GridData grid;
    int changes;
    boolean solved;
    
    public Solver () {
    }
    
    /**This method will begin solving the Sudoku grid, by using the multiple methods of solving one after the other.
     * The solving methods contained will be repeated until the puzzle is solved or it can no longer advance.
     * 
     */
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
                    solutions = new char[9];
                    this.fillSolutions();
                    this.ownSubGridCompare(i, j);
                    this.rowCompare(j);
                    this.columnCompare(i);
                    this.fillDefinite(i, j);
                    
                }
            }
        }
       this.changesLoop();
       this.hasBeenSolved();
    }
    
    /**
     * This method checks to see if any elements of the char array still contains blanks.
     * If it has found blanks it will set the boolean solved variable to false.
     */
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
    
    /**
     * This method checks if any changes were made to the char grid after running the solve() method.
     * If changes were made it will run the solve() repeatedly until no changes were found.
     */
    public void changesLoop() {
        if (changes !=0) {
            this.solve();
        }
    }
/**This method will check the possible values a square can have.
 * If only a single value may be entered, it will enter that value.
 * Any elements of the solution char array which have the value 'X' is deemed to not be a possible value for that square.
 * 
 * @param i i coordinate
 * @param j j coordinate
 */    
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
        System.out.println("POSSIBLE SOLUTIONS FOR Grid ["+i+","+j+"]");//Shows the possible solution(s) each square can have
        for (int z=0;z<9;z++) {
            if (this.getSolution(z) != 'X') {
            System.out.println(this.getSolution(z));
            }
        }
    }
    /**This method will check the other values within it's 3x3 sub-grid.
     * Any solutions eliminated will be replaced with a 'X' value.
     * 
     * @param i i coordinate
     * @param j j coordinate
     */
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
    
    /**This method will check all the values within the same column.
     * Any solutions eliminated will be replaced with a 'X' value.
     * 
     * @param i i coordinate to determine which column
     */
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
    
    /**This method will check all values within the same row.
     * Any solutions eliminated will be replaced with a 'X' value.
     * 
     * @param j j coordinate to determine which row
     */
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
    
    /**
     * This method filles up the char[] array for the possible solutions of each square, with the char values of 1 to 9.
     */
    public void fillSolutions() {
        int i,i2;
        char v;
        for (i=0;i<9;i++) {
            i2 = i + 1;
            v = Character.forDigit(i2,10);
            this.setSolutions(i, v);
        }
    }
    /**This method set's the value of an element in the array of possible solutions.
     * Is mostly used to change the value to 'X' to eliminate a possible solution.
     * 
     * @param i reference
     * @param v char value to change to
     */
    public void setSolutions(int i, char v) {
        solutions[i] = v;
    }
    /**This method returns the value of an element in the possible solutions array.
     * 
     * @param i reference
     * @return char value held by the array
     */
    public char getSolution(int i) {
        return solutions[i];
    }
    
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
