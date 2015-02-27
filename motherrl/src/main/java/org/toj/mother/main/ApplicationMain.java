package org.toj.mother.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import org.toj.mother.ui.terminal.screens.Screen;
import org.toj.mother.ui.terminal.screens.StartScreen;

import external.trystan.asciiPanel.AsciiPanel;

public class ApplicationMain extends JFrame implements KeyListener {
    private static final long serialVersionUID = -3052222924962345699L;
    private AsciiPanel terminal;
    private Screen screen;

    public ApplicationMain() {
        super();
        terminal = new AsciiPanel();
        add(terminal);
        pack();
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }

    public void repaint() {
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
