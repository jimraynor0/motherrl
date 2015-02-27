package org.toj.mother.ui.terminal.screens;

import java.awt.event.KeyEvent;

import external.trystan.asciiPanel.AsciiPanel;

public interface Screen {
    public static final int WIDTH = 80;
    public static final int HEIGHT = 21;

    public void displayOutput(AsciiPanel terminal);

    public Screen respondToUserInput(KeyEvent key);
}
