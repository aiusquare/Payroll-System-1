/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.payroll;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.ActiveEvent;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

/**
 *
 * @author Default
 */
public class TicTacToe extends JPanel {

    JButton buttons[] = new JButton[9];
    int alternate = 0;

    public TicTacToe() {
        setLayOut(new GridLayout(3, 3));
        initializebuttons();
    }

    private void setLayOut(GridLayout gridLayout) {

    }

    private void initializebuttons() {
        for (int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setText(" ");
            buttons[i].addActionListener(new buttonListener());
            add(buttons[i]);

        }
    }

    public void resetButtons() {
        for (int i = 0; i <= 8; i++) {
            buttons[i].setText(" ");

        }
    }

    private class buttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jb = (JButton) e.getSource();
            if (alternate % 2 == 0) {
                jb.setText("X");
            } else {
                jb.setText("O");
            }
            if (checkForWin() == true) {
                JOptionPane.showMessageDialog(null, "Game is over");
                resetButtons();
            }

            alternate++;
        }

        private boolean checkForWin() {
            if (checkAdjacent(0, 1) && checkAdjacent(1, 2)) {
                return true;
            } else if (checkAdjacent(3, 4) && checkAdjacent(4, 5)) {
                return true;
            } else if (checkAdjacent(6, 7) && checkAdjacent(7, 8)) {
                return true;
            } else if (checkAdjacent(0, 3) && checkAdjacent(3, 6)) {
                return true;
            } else if (checkAdjacent(1, 4) && checkAdjacent(4, 7)) {
                return true;
            } else if (checkAdjacent(2, 5) && checkAdjacent(5, 8)) {
                return true;
            } else if (checkAdjacent(0, 4) && checkAdjacent(4, 8)) {
                return true;
            } else if (checkAdjacent(2, 4) && checkAdjacent(4, 6)) {
                return true;
            } else {
                return false;
            }

        }   

   

    

        private boolean checkAdjacent(int a, int b) {
            if (buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals(" ")) 
                return true;
             else 
                return false;
            }

        }

        public static void main(String args[]) {

            JFrame window = new JFrame("TicTacToe");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.getContentPane().add(new TicTacToe());
            window.setBounds(500,500, 170, 160);
            window.setVisible(true);
        }

    }
