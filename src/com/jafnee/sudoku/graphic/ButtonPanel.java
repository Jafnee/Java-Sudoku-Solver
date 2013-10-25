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

/**This class will be contain JButtons that the user will use to interact with the program.
 *
 * @author Jafnee Jesmee
 * @version 25/10/2013
 */

public class ButtonPanel extends JPanel implements ActionListener {
    JButton load,solve,clear;
    JFileChooser chooser;
    GridPanel gridpanel;
    String currentFile;
    ContainerPanel panel;
    Solver solver;
    
    /**The default constructor will create the JButtons and adds them to the JPanel.
     * The ActionListeners are also created.
     * 
     */
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
            System.out.println("File not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("General I/O exception: " + ex.getMessage());
        }
        if (e.getSource() == solve)
            this.startSolver();
        //if (e.getSource() == clear)
            //System.out.println("CLEAR");
    }
    /**The method makes use of the JFileChooser which will create a user friendly interface that the user can use to
     * navigate to the file they want to open. The JFileChooser will only accept files with the .SUD extension.
     * Once the file is selected, the program will begin to fill the grid will the data stored in the .SUD file and display it.
     * It will also update the Title of the JFrame to show the current name of the file loaded up.
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
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
    /**
     * This method starts the solving method located in the Solver class.
     * once solving is completed, it will check whether the puzzle is fully or partially solved and
     * will give the appropriate message to the user.
     */
    public void startSolver() {
        this.getGridPanel().gridData.getSolver().Solve();
        this.getGridPanel().fillGrid();
        if (getGridPanel().gridData.getSolver().getSolved() == true) {
            JOptionPane.showMessageDialog(null,"Has been fully solved","",JOptionPane.PLAIN_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null,"Could only be partially solved.","",JOptionPane.PLAIN_MESSAGE);
        }
        
        
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
