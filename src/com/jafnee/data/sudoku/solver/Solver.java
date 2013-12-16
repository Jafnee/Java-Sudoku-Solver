/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.data.sudoku.solver;

import com.jafnee.sudoku.data.GridData;
import com.jafnee.sudoku.data.PossibleSolutions;

/**
 *
 * @author Jafnee
 */
public class Solver {
    GridData gridData;
    
    public Solver(GridData gd) {
        gridData = gd;        
    }
    
    public GridData getGridData() {
        return gridData;
    }
}
