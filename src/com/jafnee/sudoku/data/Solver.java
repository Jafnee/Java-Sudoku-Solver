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
    GridData grid;
    
    public Solver () {
       //solutions = new char[10];
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
                    this.rowCompare(i);
                    this.coloumnCompare(j);
                    this.fillDefinite(i, j);
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
            }
        System.out.println("POSSIBLE SOLUTIONS FOR Grid ["+i+","+j+"]");
        for (int z=0;z<9;z++) {
            System.out.println(this.getSolution(z));
        }
        
    }
    
    public void rowCompare(int i) {
        int j, s;        
        for (j=0;j<9;j++) {
            for (s=0;s<9;s++) {
//            System.out.println("Square Value == [" + this.getGridData().getValue(i, j) + "]");
//            System.out.println("getSolution(j) == " + this.getSolution(j));
//            System.out.println("value == getSolution(j) is " + (this.getGridData().getValue(i, j) == getSolution(j)));
            if (this.getGridData().getValue(i, j) == this.getSolution(s)) { // if value is equal to j in solution array
                this.setSolutions(s, 'X'); // set solution j to 'X'
//                System.out.println("Value "+this.getGridData().getValue(i, j)+"found at: ["+i+","+j+"]");
            }
        }
            //System.out.println("LOL I DID NOTHING! For Grid: {"+i+","+j+"]");
        }
    }
    
    public void coloumnCompare(int j) {
        int i, s;
        for (i=0;i<9;i++) {
            for (s=0;s<9;s++) {
            if (this.getGridData().getValue(i, j) == this.getSolution(s)) {
                this.setSolutions(s, 'X');
//                System.out.println("Value "+this.getGridData().getValue(i, j)+"found at: ["+i+","+j+"]");
            }
            //System.out.println("LOL I DID NOTHING! For Grid: {"+i+","+j+"]");
            }
        }
    }
    
    public void fillSolutions() {
//        this.setSolutions(0, '1');
//        this.setSolutions(1, '2');
//        this.setSolutions(2, '3');
//        this.setSolutions(3, '4');
//        this.setSolutions(4, '5');
//        this.setSolutions(5, '6');
//        this.setSolutions(6, '7');
//        this.setSolutions(7, '8');
//        this.setSolutions(8, '9');
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
