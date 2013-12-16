/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.sudoku.main;

import com.jafnee.sudoku.data.GridData;
import com.jafnee.sudoku.graphic.MainFrame;

/**
 *
 * @author Jafnee
 */
public class Main {
    private final GridData gridData;
    private final MainFrame mainFrame;
    
    public Main() {
        gridData = new GridData(this);
        mainFrame = new MainFrame(this);
    }
    
    public GridData getGridData() {
        return gridData;
    }
    
    public MainFrame getMainFrame() {
        return mainFrame;
    }
}
