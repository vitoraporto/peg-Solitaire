package com.company;

import ui.Panel;

import javax.swing.*;

public class Resta1 extends JFrame {

    private Resta1(Game game){
        initUI(game);
    }

    private void initUI(Game game) {

        add(new Panel(game));

        setSize(700, 700);

        setTitle("Resta1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Game game = new Game();
        Resta1 r1 = new Resta1(game);
        r1.setVisible(true);
    }
}
