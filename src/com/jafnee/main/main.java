/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.main;

import com.jafnee.data.GridData;
import com.jafnee.data.solver.Solver;
import com.jafnee.graphic.ContainerPanel;

/**
 *
 * @author Jafnee
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Solver solver = new Solver();
        GridData gridData = new GridData();
        ContainerPanel containerPanel = new ContainerPanel();
    }
    
}
