package view;


import controll.Controller;

import javax.swing.*;

public class Frame extends JFrame{

    private GuiPanelHandler gui;

    public Frame(Controller controller) {
        this.gui = new GuiPanelHandler(controller);
        this.setContentPane(gui.getPanel());
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(50,50,500,400);
    }
}
