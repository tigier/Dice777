package view;

import controll.Controller;

import javax.swing.*;

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
    private JComboBox comboBox1;

    private Controller controller;

    public GuiPanelHandler(Controller controller) {
        this.controller = controller;
    }

    public JPanel getPanel(){
        return panel;
    }

}
