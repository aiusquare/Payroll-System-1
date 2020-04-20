/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.payroll;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Default
 */
public class Level1 {

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                displayJFrame();
            }

            private void displayJFrame() {
                JFrame jf = new JFrame("Sample");
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setPreferredSize(new Dimension(400, 300));
                jf.pack();
                jf.setLocationRelativeTo(null);
                jf.setVisible(true);
                jf.setBackground(Color.black);
            }
        });
        {

        }
    }
}
