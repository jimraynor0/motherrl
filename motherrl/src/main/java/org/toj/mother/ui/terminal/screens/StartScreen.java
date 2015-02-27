package org.toj.mother.ui.terminal.screens;

import java.awt.event.KeyEvent;

import org.toj.mother.game.Game;

import external.trystan.asciiPanel.AsciiPanel;

public class StartScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.write("rl tutorial", 1, 1);
        terminal.writeCenter("-- press [enter] to start --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen(
                new Game()) : this;
    }
}
