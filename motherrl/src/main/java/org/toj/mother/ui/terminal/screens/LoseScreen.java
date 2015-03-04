package org.toj.mother.ui.terminal.screens;

import java.awt.event.KeyEvent;

import external.trystan.asciiPanel.AsciiPanel;

public class LoseScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("You lost.", 18);
        terminal.writeCenter("-- press [enter] to restart --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new StartScreen() : this;
    }
}
