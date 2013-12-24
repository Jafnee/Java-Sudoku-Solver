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
    private Solver solver;
    
    public PossibleSolutions(Solver s) {
        solver = s;
        solutions = new char[9][9][9];
        setPSolutions();
    }
    
    public void setPSolutions() {
        for (int j = 0 ; j < 9 ; j++) {
            for (int i = 0; i < 9 ; i++) {
                setPSolution(i, j, 0, '1');
                setPSolution(i, j, 1, '2');
                setPSolution(i, j, 2, '3');
                setPSolution(i, j, 3, '4');
                setPSolution(i, j, 4, '5');
                setPSolution(i, j, 5, '6');
                setPSolution(i, j, 6, '7');
                setPSolution(i, j, 7, '8');
                setPSolution(i, j, 8, '9');
            }
        }
    }
    
    public void setPSolution(int i, int j,int n , char v) {
        solutions[i][j][n] = v;
    }
    
    public char getPSolution(int i, int j, int n) {
        return solutions[i][j][n];
    }
    
    public char[][][] getSolutions() {
        return solutions;
    }
    
    public void printPSolutions() {
        String coord = "";
        String solutions = "";
        for (int j = 0 ; j < 9 ; j++) {
            for (int i = 0 ; i < 9 ; i++) {
                solutions = "";
                if (getSolver().getGridModel().getValue(i, j) == ' ') {
                    coord = "["+i+","+j+"]";
                    for (int n = 0 ; n < 9 ; n++) {
                        if (getPSolution(i,j,n) != 'X') {
                            solutions = solutions + getPSolution(i,j,n) + ",";
                        }
                    }
                    System.out.println(coord+" "+solutions);
                } else {
                    coord ="";
                    System.out.println(getSolver().getGridModel().getValue(i, j));
                }
                
            }
        }
    }
    
    public Solver getSolver() {
        return solver;
    }
}
