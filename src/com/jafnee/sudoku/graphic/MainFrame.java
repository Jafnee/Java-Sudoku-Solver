/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.sudoku.graphic;

import com.jafnee.data.sudoku.solver.Solver;
import com.jafnee.sudoku.main.Main;
import com.jafnee.sudoku.main.Start;
import javax.swing.JFrame;

/**
 *
 * @author Jafnee
 */
public class MainFrame extends JFrame{
    private final ContainerPanel containerPanel;
    private final Main main;
    
    public MainFrame(Main m) {                        
        main = m;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        containerPanel = new ContainerPanel(this);
        add(containerPanel);
        setSize(600, 600);
        //this.setResizable(false);
        setVisible(true);
        setTitle("File loaded: No file loaded");
    }
    
    public Main getMain() {
        return main;
    }
    
    public ContainerPanel getContainerPanel() {
        return containerPanel;
    }    
    
}
