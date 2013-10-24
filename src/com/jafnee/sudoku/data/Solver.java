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
       //solutions = new char[9];
    }
    
    public void Solve() {
         int i,j;
         char value;
       for (j=0;j<9;j++) {
            for (i=0;i<9;i++) {
                value = this.getGridData().getValue(i, j);
                if (value != ' ') {
                    System.out.println("already has a value: "+value);
                }
                else {
                    System.out.println("IS BLANK");
                }
               
                    
               
            }
        }
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
