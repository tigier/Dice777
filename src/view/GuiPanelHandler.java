package view;

import controll.Controller;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPanelHandler {
    private JProgressBar progressBar1;
    private JButton button1;
    private JButton button4;
    private JButton button2;
    private JButton button3;
    private JTable table1;
    private JButton button6;
    private JFormattedTextField formattedTextField1;
    private JButton button5;
    private JPanel panel;
    String[] combo = {"10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50"};
    private JComboBox comboBox;
    private JButton button7;
    private JButton button8;

    private Controller controller;

    public GuiPanelHandler(Controller controller) {
        this.controller = controller;
        setComboBox();
        comboBox.setSelectedIndex(7);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.isStarted()) {
                    controller.setDiceUp(1);
                    disable(1);
                }
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.isStarted()) {
                    controller.setDiceUp(2);
                    disable(2);
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.isStarted()) {
                    controller.setDiceUp(3);
                    disable(3);
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.isStarted()) {
                    controller.setDiceUp(6);
                    disable(6);
                }
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.isStarted()) {
                    controller.setDiceUp(5);
                    disable(5);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.isStarted()) {
                    controller.setDiceUp(4);
                    disable(4);
                }
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.start();
                disable(controller.getDiceUp());
                update();
                button6.setEnabled(false);
                button5.setEnabled(false);
                comboBox.setEnabled(false);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.activateai();
                controller.start();
                disable(controller.getDiceUp());
                update();
                button6.setEnabled(false);
                button5.setEnabled(false);
                comboBox.setEnabled(false);
            }
        });
    }

    public JPanel getPanel(){
        return panel;
    }

    public void disable(int i){
        switch (i){
            case 1:
                button4.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button7.setEnabled(true);
                button8.setEnabled(true);
                update();
                break;
            case 2:
                button7.setEnabled(false);
                button8.setEnabled(false);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button1.setEnabled(true);
                button1.setEnabled(true);
                button4.setEnabled(true);
                update();
                break;
            case 3:
                button2.setEnabled(false);
                button3.setEnabled(false);
                button1.setEnabled(true);
                button4.setEnabled(true);
                button7.setEnabled(true);
                button8.setEnabled(true);
                update();
                break;
            case 4:
                button3.setEnabled(false);
                button2.setEnabled(false);
                button1.setEnabled(true);
                button4.setEnabled(true);
                button7.setEnabled(true);
                button8.setEnabled(true);
                update();
                break;
            case 5:
                button8.setEnabled(false);
                button7.setEnabled(false);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button1.setEnabled(true);
                button4.setEnabled(true);
                update();
                break;
            case 6:
                button1.setEnabled(false);
                button4.setEnabled(false);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button7.setEnabled(true);
                button8.setEnabled(true);
                update();
                break;
        }
    }

    private void setComboBox(){
        for(int i = 0; i <= 40; i++) {
            comboBox.addItem(combo[i]);
        }
    }

    private void update(){
        progressBar1.setMaximum(comboBox.getSelectedIndex() + 10);
        progressBar1.setForeground(Color.blue);
        TableModel dataModel = new AbstractTableModel() {
            public int getColumnCount() { return 2; }
            public int getRowCount() { return 18;}
            public Object getValueAt(int row, int col) {
                if(row == 0){
                    if(col == 0){
                        return "player1";
                    }
                    else{
                        return "player2";
                    }
                }
                else{
                    if(col == 0){
                        if(controller.getPlayer1().length > row - 1){
                            return controller.getPlayer1()[row - 1];
                        }
                        else{
                            return 0;
                        }
                    }
                    else{
                        if(controller.getPlayer2().length > row - 1){
                            return controller.getPlayer2()[row - 1];
                        }
                        else{
                            return 0;
                        }
                    }
                }
            }
        };
        table1.setModel(dataModel);
        progressBar1.setValue(controller.getPoints());
        progressBar1.setString(controller.getPoints() + "/" + (comboBox.getSelectedIndex() +10));
        if(controller.getPoints() > comboBox.getSelectedIndex() + 10){
            button4.setEnabled(false);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button6.setEnabled(true);
            button5.setEnabled(true);
            comboBox.setEnabled(true);
            controller.deactivateai();
            if(controller.isPlayer()){
                formattedTextField1.setText("Player 1 missed the goal! Player 2 Wins!");
                progressBar1.setForeground(Color.red);
                controller.end();
            }
            else{
                formattedTextField1.setText("Player 2 missed the goal! Player 1 Wins!");
                progressBar1.setForeground(Color.red);
                controller.end();
            }
        }
        else if(controller.getPoints() == comboBox.getSelectedIndex() + 10){
            button4.setEnabled(false);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button6.setEnabled(true);
            button5.setEnabled(true);
            comboBox.setEnabled(true);
            controller.deactivateai();
            System.out.print(1);
            if(controller.isPlayer()){
                formattedTextField1.setText("Player 1 Wins by hitting the goal!");
                progressBar1.setForeground(Color.green);
                controller.end();
            }
            else{
                formattedTextField1.setText("Player 2 Wins by hitting the goal!");
                progressBar1.setForeground(Color.green);
                controller.end();
            }
        }
        else{
            if(controller.isPlayer()){
                if(controller.isAi()){
                    ai();
                }
                else {
                    formattedTextField1.setText("Player 2, tip the dice!");
                }
            }
            else{
                formattedTextField1.setText("Player 1, tip the dice!");
            }
        }
    }

    public void ai(){
        switch (comboBox.getSelectedIndex() + 10 - controller.getPoints()){
            case 1:
                if(button4.isEnabled()){
                    controller.setDiceUp(1);
                    disable(1);
                    break;
                }
                else{
                    controller.setDiceUp(2);
                    disable(2);
                    break;
                }
            case 2:
                if(button7.isEnabled()){
                    controller.setDiceUp(2);
                    disable(2);
                    break;
                }
                else{
                    controller.setDiceUp(1);
                    disable(1);
                    break;
                }
            case 3:
                if(button2.isEnabled()){
                    controller.setDiceUp(3);
                    disable(3);
                    break;
                }
                else{
                    controller.setDiceUp(2);
                    disable(2);
                    break;
                }
            case 4:
                if(button2.isEnabled()){
                    controller.setDiceUp(4);
                    disable(4);
                    break;
                }
                else{
                    controller.setDiceUp(1);
                    disable(1);
                    break;
                }
            case 5:
                if(button7.isEnabled()){
                    controller.setDiceUp(5);
                    disable(5);
                    break;
                }
                else {
                    controller.setDiceUp(1);
                    disable(1);
                    break;
                }
            case 6:
                if(button4.isEnabled()){
                    controller.setDiceUp(6);
                    disable(6);
                    break;
                }
                else{
                    controller.setDiceUp(3);
                    disable(3);
                    break;
                }
            case 7:
                if(button4.isEnabled()){
                    controller.setDiceUp(6);
                    disable(6);
                    break;
                }
                else{
                    controller.setDiceUp(2);
                    disable(2);
                    break;
                }
            default:
                if(button4.isEnabled()){
                    controller.setDiceUp(1);
                    disable(1);
                }
                else{
                    controller.setDiceUp(2);
                    disable(2);
                }
        }
    }
}
