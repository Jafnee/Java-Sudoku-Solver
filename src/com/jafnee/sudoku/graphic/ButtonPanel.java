/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.sudoku.graphic;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
 *
 * @author Jafnee
 */
public class ButtonPanel extends JPanel implements ActionListener {
    private final ContainerPanel containerPanel;
    private final JButton load,solve;
    private JFileChooser chooser;
    
    public ButtonPanel(ContainerPanel cp) 
    {
        containerPanel = cp;
        
        load = new JButton("Load");
        solve = new JButton("Solve");
        this.setLayout(new GridLayout(0,2));
        this.add(load);
        this.add(solve);
        load.addActionListener(this);
        solve.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == load)
            try {
            loadFile();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("General I/O exception: " + ex.getMessage());
        }
        if (e.getSource() == solve)
            startSolver();    
    }
    
    public void startSolver() 
    {
        getContainerPanel().getMainFrame().getMain().getGridModel().getSolver().solve();
        getContainerPanel().getGridView().fillGrid();
    }
    
     public void loadFile() throws FileNotFoundException, IOException 
     {
        chooser = new JFileChooser();
        String filePath;
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".SUD Files","sud");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            System.out.println(file);
            containerPanel.getMainFrame().getMain().getGridModel().loadGrid(file);
            containerPanel.getGridView().fillGrid();
            filePath = file.getName();
            getContainerPanel().getMainFrame().setTitle("File loaded: "+filePath);
            //this.getContainerPanel().getMyFrame().setTitle("File loaded: "+this.getCurrentFile());
        }
    }
     
     public ContainerPanel getContainerPanel() 
     {
         return containerPanel;
     }
}

