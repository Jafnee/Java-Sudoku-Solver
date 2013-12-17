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
    boolean canContinue;
    
    public Solver(GridModel gd) {
        gridModel = gd;
        possibleSolutions = new PossibleSolutions();
    }
    
    public void solve() {
        canContinue = false;
        char currentValue;
        for (int j = 0 ; j < 9 ; j++) {
            for (int i = 0; i < 9 ; i++) {
                currentValue = getGridModel().getValue(i, j);
                if (currentValue == ' ') {
                    compareRow(i,j);
                    compareColumn(i,j);
                    subGridCompare(i,j);
                    fillDefinite(i, j);
                }
            }
        }
        if (canContinue) {
            solve();
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
            canContinue = true;
        }
    }
    
    public void compareRow(int i, int j) {
        char currentValue;
        int currentValuePosition;
        for (int i2 = 0 ; i2 < 9 ; i2++) {
            currentValue = getGridModel().getValue(i2, j);
            if (currentValue != ' ') {
                currentValuePosition = (Character.getNumericValue(currentValue)) - 1;
                possibleSolutions.setPSolution(i,j,currentValuePosition,'X');
            }
        }
    }
    
    public void compareColumn(int i, int j) {
        char currentValue;
        int currentValuePosition;
        for (int j2 = 0 ; j2 < 9 ; j2++) {
            currentValue = getGridModel().getValue(i, j2);
            if (currentValue != ' ') {
                currentValuePosition = (Character.getNumericValue(currentValue)) - 1;
                possibleSolutions.setPSolution(i,j,currentValuePosition,'X');
            }
        }
    }
    
    public  void subGridCompare(int i, int j) {
       char currentValue;
       int currentValuePosition;
       int i2Min, j2Min, i2Max, j2Max;
       j2Min = ((j/3)*3);
       j2Max = j2Min + 3;
       i2Min = ((i/3)*3);
       i2Max = i2Min + 3;
       for (int j2 = j2Min; j2 < j2Max ; j2++ ) {
           for (int i2 = i2Min; i2 < i2Max ; i2++) {
               currentValue = getGridModel().getValue(i2, j2);
               if (currentValue != ' ') {
                   currentValuePosition = (Character.getNumericValue(currentValue)) - 1;
                   possibleSolutions.setPSolution(i, j, currentValuePosition, 'X');
               }
           }
       }
    }
    
    public GridModel getGridModel() {
        return gridModel;
    }
    
    public PossibleSolutions getPossibleSolutions() {
        return possibleSolutions;
    }
}
