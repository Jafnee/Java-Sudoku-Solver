/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.data.sudoku.solver;
/**
 *
 * @author Jafnee
 */
public class PossibleSolutions {
    private char[][][] solutions;
    
    public PossibleSolutions() {
        solutions = new char[9][9][9];
        setPSolutions();
    }
    
    public void setPSolutions() {
        for (int j = 0 ; j < 9 ; j++) {
            for (int i = 0; i < 9 ; i++) {
                setPSolution(i, j,0, '1');
                setPSolution(i, j,1, '2');
                setPSolution(i, j,2, '3');
                setPSolution(i, j,3, '4');
                setPSolution(i, j,4, '5');
                setPSolution(i, j,5, '6');
                setPSolution(i, j,6, '7');
                setPSolution(i, j,7, '8');
                setPSolution(i, j,8, '9');
            }
        }
    }
    
    public void setPSolution(int i, int j,int n , char v) {
        solutions[i][j][n] = v;
    }
    
    public char getPSolution(int i, int j, int n) {
        return solutions[i][j][n];
    }
}
