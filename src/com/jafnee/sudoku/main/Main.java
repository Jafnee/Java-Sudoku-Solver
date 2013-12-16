/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.sudoku.main;

import com.jafnee.sudoku.data.GridModel;
import com.jafnee.sudoku.graphic.MainFrame;

/**
 *
 * @author Jafnee
 */
public class Main {
    private final GridModel gridData;
    private final MainFrame mainFrame;
    
    public Main() {
        gridData = new GridModel(this);
        mainFrame = new MainFrame(this);
    }
    
    public GridModel getGridModel() {
        return gridData;
    }
    
    public MainFrame getMainFrame() {
        return mainFrame;
    }
}
