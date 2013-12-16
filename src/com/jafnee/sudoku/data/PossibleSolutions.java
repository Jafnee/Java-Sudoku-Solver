/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.sudoku.data;
/**
 *
 * @author Jafnee
 */
public class PossibleSolutions {
    private char[][][] solutions;
    
    public PossibleSolutions() {
        solutions = new char[9][9][9];
        setSolutions();
    }
    
    public void setSolutions() {
        for (int j = 0 ; j < 9 ; j++) {
            for (int i = 0; i < 9 ; i++) {
                setSolution(i, j,0, '1');
                setSolution(i, j,1, '2');
                setSolution(i, j,2, '3');
                setSolution(i, j,3, '4');
                setSolution(i, j,4, '5');
                setSolution(i, j,5, '6');
                setSolution(i, j,6, '7');
                setSolution(i, j,7, '8');
                setSolution(i, j,8, '9');
            }
        }
    }
    
    public void setSolution(int i, int j,int n , char v) {
        solutions[i][j][n] = v;
    }
}
