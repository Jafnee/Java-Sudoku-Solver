/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.data;

import com.jafnee.data.solver.Solver;
import com.jafnee.main.Main;

/**
 *
 * @author Jafnee
 */
public class GridData {
    Main main;
    Solver solver;
    
    public GridData(Main m) {
        main = m;
        solver = new Solver(this);
        
    }
}
