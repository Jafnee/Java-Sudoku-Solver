/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafnee.sudoku.graphic;

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
    
    public ButtonPanel() {
        load = new JButton("Load");
        solve = new JButton("Solve");
        clear = new JButton("Clear");
        this.setLayout(new GridLayout(0,3));
        this.add(load);
        this.add(solve);
        this.add(clear);
        load.addActionListener(this);
        solve.addActionListener(this);
        clear.addActionListener(this);
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
            System.out.println("SOLVE");
        if (e.getSource() == clear)
            System.out.println("CLEAR");
    }
    
    public void loadFile() throws FileNotFoundException, IOException {
        chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("SUD Files","sud");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            System.out.println(file);
            gridpanel.test();
            gridpanel.gridData.loadGrid(file);
            
        }
    }
    
    public void setGridPanel(GridPanel gp) {
        gridpanel = gp;
    }
}
