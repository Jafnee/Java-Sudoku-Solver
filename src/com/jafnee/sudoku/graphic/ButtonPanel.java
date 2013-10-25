/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafnee.sudoku.graphic;

import com.jafnee.sudoku.data.Solver;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jafnee
 */
public class ButtonPanel extends JPanel implements ActionListener {
    JButton load,solve,clear;
    JFileChooser chooser;
    GridPanel gridpanel;
    String currentFile;
    ContainerPanel panel;
    Solver solver;
    
    public ButtonPanel() {
        load = new JButton("Load");
        solve = new JButton("Solve");
        //clear = new JButton("Clear");
        this.setLayout(new GridLayout(0,2));
        this.add(load);
        this.add(solve);
        //this.add(clear);
        load.addActionListener(this);
        solve.addActionListener(this);
        //clear.addActionListener(this);
    }
    
    @Override
   public void actionPerformed(ActionEvent e) {
        if (e.getSource() == load)
            try {
            this.loadFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (e.getSource() == solve)
            this.startSolver();
        //if (e.getSource() == clear)
            //System.out.println("CLEAR");
    }
    
    public void loadFile() throws FileNotFoundException, IOException {
        chooser = new JFileChooser();
        String filePath;
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".SUD Files","sud");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            System.out.println(file);
            gridpanel.gridData.loadGrid(file);
            gridpanel.fillGrid();
            filePath = file.getName();
            this.setCurrentFile(filePath);
            this.getContainerPanel().getMyFrame().setTitle("File loaded: "+this.getCurrentFile());
            
        }
    }
    
    public void startSolver() {
        this.getGridPanel().gridData.getSolver().Solve();
        this.getGridPanel().fillGrid();
    }
    
    public void setGridPanel(GridPanel gp) {
        gridpanel = gp;
    }
    
    public GridPanel getGridPanel() {
        return gridpanel;
    }
    
    public void setCurrentFile(String f) {
        currentFile = f;
    }
    
    public String getCurrentFile() {
        return currentFile;
    }
    
    public ContainerPanel getContainerPanel() {
        return panel;
    }
    
    public void setContainerPanel(ContainerPanel cp) {
        panel = cp;
    }
}
