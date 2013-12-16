/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jafnee.main;

import com.jafnee.data.GridData;
import com.jafnee.graphic.MainFrame;

/**
 *
 * @author Jafnee
 */
public class Main {
    public Main() {
        GridData gridData = new GridData(this);
        MainFrame mainFrame = new MainFrame(this);
    }
}
