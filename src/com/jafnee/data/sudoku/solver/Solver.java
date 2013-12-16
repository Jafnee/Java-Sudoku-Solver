/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.data.sudoku.solver;

import com.jafnee.sudoku.data.GridModel;

/**
 *
 * @author Jafnee
 */
public class Solver {
    private final GridModel gridModel;
    
    public Solver(GridModel gd) {
        gridModel = gd;        
    }
    
    public void solve() {
        char value;
        System.out.println("SOLVE!");
        for (int j = 0 ; j < 9 ; j++) {
            for (int i = 0; i < 9 ; i++) {
                value = getGridModel().getValue(i, j);
                System.out.println(value);
            }
        }
    }
    
    public boolean compareRow(int j, char c) {
//        for (int i = 0 ; i < 9 ; i++) {
//            if ()
//        }
        return true;
    }
    
    public GridModel getGridModel() {
        return gridModel;
    }
}
