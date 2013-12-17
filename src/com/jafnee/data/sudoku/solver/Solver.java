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
    private final PossibleSolutions possibleSolutions;
    
    public Solver(GridModel gd) {
        gridModel = gd;
        possibleSolutions = new PossibleSolutions();
    }
    
    public void solve() {
        char currentValue;
        for (int j = 0 ; j < 9 ; j++) {
            for (int i = 0; i < 9 ; i++) {
                currentValue = getGridModel().getValue(i, j);
                if (currentValue == ' ') {
                    compareRow(i,j);
                    compareColumn(i,j);
                    fillDefinite(i, j);
                }
            }
        }
    }
    
    public void fillDefinite(int i, int j) {
        char definiteSolution = 0;
        int noOfPSolutions = 0;
        for (int n = 0 ; n < 9 ; n++) {
            if (possibleSolutions.getPSolution(i, j, n) != 'X') {
                noOfPSolutions++;
                definiteSolution = possibleSolutions.getPSolution(i, j, n);
            }
        }
        if (noOfPSolutions == 1) {
            getGridModel().setValue(i, j, definiteSolution);
        }
    }
    
    public void compareRow(int i2, int j) {
        char currentValue;
        int currentValuePosition;
        for (int i = 0 ; i < 9 ; i++) {
            currentValue = getGridModel().getValue(i, j);
            if (currentValue != ' ') {
                currentValuePosition = (Character.getNumericValue(currentValue)) - 1;
                possibleSolutions.setPSolution(i2,j,currentValuePosition,'X');
            }
        }
    }
    
    public void compareColumn(int i, int j2) {
        char currentValue;
        int currentValuePosition;
        for (int j = 0 ; j < 9 ; j++) {
            currentValue = getGridModel().getValue(i, j);
            if (currentValue != ' ') {
                currentValuePosition = (Character.getNumericValue(currentValue)) - 1;
                possibleSolutions.setPSolution(i,j2,currentValuePosition,'X');
            }
        }
    }
    
    public GridModel getGridModel() {
        return gridModel;
    }
}
