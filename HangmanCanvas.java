/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		// Create SCAFFOLD
		double s_x = 0.5 * getWidth() - BEAM_LENGTH;
		double shigh_y = 0.05 * getHeight();
		double slow_y = shigh_y + SCAFFOLD_HEIGHT;
		GLine scaffold = new GLine(s_x, shigh_y, s_x, slow_y);
		add(scaffold);
		
		// Create beamer
		double bleft_x = 0.5 * getWidth() - BEAM_LENGTH;
		double b_y = 0.05 * getHeight();
		double bright_x = 0.5 * getWidth();
		GLine beamer = new GLine(bleft_x, b_y, bright_x, b_y);
		add(beamer);
		
		// Creat rope
		double r_x = 0.5 * getWidth();
		double rhigh_y = 0.05 * getHeight();
		double rlow_y = shigh_y + ROPE_LENGTH;
		GLine rope = new GLine(r_x, rhigh_y, r_x, rlow_y);
		add(rope);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		GLabel wordLabel = new GLabel(word, 0.25*getWidth()-BEAM_LENGTH, 0.85*getHeight());
		wordLabel.setFont("Purisa-30");
		add(wordLabel);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	String inco_update = "";

}
