package view;


import controll.Controller;

import javax.swing.*;

public class Frame extends JFrame{

    private Gui gui;
    private Controller controller;

    public Frame(Controller controller) {
        this.controller = controller;
        this.gui = new Gui(controller);

    }
}
