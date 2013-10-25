/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafnee.sudoku.data;

/**
 *
 * @author Jafnee
 */
public class Solver {
    char[] solutions;
    char[][][] storedSolutions;
    GridData grid;
    
    public Solver () {
       storedSolutions = new char[9][9][9];
    }
    
    public void Solve() {
         int i,j;
         char value;
       for (j=0;j<9;j++) {
            for (i=0;i<9;i++) {
                value = this.getGridData().getValue(i, j);
//                System.out.println("Value at solve "+value);
                if (value != ' ') {
//                    System.out.println("already has a value: "+value);
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
    }
    
    public void fillDefinite(int i, int j) {
        //String possibleSolutions = "Possible solutions: ";
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
            }
        System.out.println("POSSIBLE SOLUTIONS FOR Grid ["+i+","+j+"]");
        for (int z=0;z<9;z++) {
            if (this.getSolution(z) != 'X') {
                //possibleSolutions += this.getSolution(z);
            System.out.println(this.getSolution(z));
            }
            //System.out.println(possibleSolutions);
        }
    }
    
    public void subGridDefinite(int i, int j) {
        
        
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
//            System.out.println("TempJ IS: "+tempJ2);
//            System.out.println("J is: "+j);
            for (tempI2 = tempI*3;tempJ2<tempJ3;tempJ2++) {
                for (s=0;s<9;s++) {
//                    System.out.println("checking against possibilities");
//                    System.out.println("Looking at Grid: ["+tempI2+","+tempJ2+"] solution element: "+this.getSolution(s));
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
            //System.out.println(v);
            this.setSolutions(i, v);
            //System.out.println(this.getSolution(i));
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
//    public void eliminate(){
//        //will include all 3 eliminate methods
//    }
//    
//    public void definite(){
//        //will invlude all 3 definite methods
//    }
//    
//    public void rowEliminate() {
//        
//    }
//    
//    public void columnEliminate() {
//        
//    }
//    
//    public void subGridEliminate() {
//        
//    }
//    
//   public void rowDefinite() {
//       
//   } 
//   
//   public void columnDefinite() {
//       
//   }
//   
//   public void subGridDefinite() {
//       
//   }
}
