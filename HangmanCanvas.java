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
		if (getElementAt(0.1*getWidth(), 0.9*getHeight()) != null) {
			remove(wordLabel);
		}
		wordLabel = new GLabel(word, 0.1*getWidth(), 0.9*getHeight());
		wordLabel.setFont("Purisa-26");
		add(wordLabel);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		double x;
		if (getElementAt(0.1*getWidth(), 0.95*getHeight()) == null) {
			x = 0.1*getWidth();
		} else {
			x = incoLabel.getX()+incoLabel.getWidth();
		}
		String letterToStr = Character.toString(letter);
		incoLabel = new GLabel(letterToStr, x, 0.95*getHeight());
		incoLabel.setFont("Purisa-14");
		add(incoLabel);
		addBodyParts(n);
		n--;
		
	}

	/* Add body parts to canvas according to count */
	private void addBodyParts(int n) {
		switch(n) {
		case 0: addRightFoot();
		case 1: addLeftFoot();
		case 2: addRightLeg();
		case 3: addLeftLeg();
		case 4: addRightArm();
		case 5: addLeftArm();
		case 6: addBody();
		case 7: addHead();
		}
	}
	
	private void addHead() {
		GOval head = new GOval(0.5*getWidth()-HEAD_RADIUS, 0.05*getHeight()-ROPE_LENGTH, 2*HEAD_RADIUS, 2*HEAD_RADIUS);
		add(head);
	}
	
	private void addBody() {
		GLine body = new GLine(0.5*getWidth(), 0.05*getHeight()-ROPE_LENGTH+2*HEAD_RADIUS, 0.5*getWidth(), 0.05*getHeight()-ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
		add(body);
	}
	
	private void addLeftArm() {
		double left_x = 0.5*getWidth()-UPPER_ARM_LENGTH;
		double upper_y = 0.05*getHeight()-ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD;
		double lower_y = 0.05*getHeight()-ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH;
		double right_x = 0.5*getWidth();
		GLine upperArm = new GLine(left_x, upper_y, right_x, upper_y);
		GLine lowerArm = new GLine(left_x, upper_y, left_x, lower_y);
		add(upperArm);
		add(lowerArm);	
	}
	
	private void addRightArm() {
		double left_x = 0.5*getWidth();
		double upper_y = 0.05*getHeight()-ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD;
		double lower_y = 0.05*getHeight()-ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH;
		double right_x = 0.5*getWidth()+UPPER_ARM_LENGTH;
		GLine upperArm = new GLine(left_x, upper_y, right_x, upper_y);
		GLine lowerArm = new GLine(left_x, upper_y, left_x, lower_y);
		add(upperArm);
		add(lowerArm);	
	}
	
	private void addLeftLeg() {
		double left_x = 0.5*getWidth()-HIP_WIDTH;
		double upper_y = 0.05*getHeight()-ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH;
		double lower_y = 0.05*getHeight()-ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH;
		double right_x = 0.5*getWidth();
		GLine upperLeg = new GLine(left_x, upper_y, right_x, upper_y);
		GLine lowerLeg = new GLine(left_x, upper_y, left_x, lower_y);
		add(upperLeg);
		add(lowerLeg);	
	}
	
	private void addRightLeg() {
		double left_x = 0.5*getWidth();
		double upper_y = 0.05*getHeight()-ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH;
		double lower_y = 0.05*getHeight()-ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH;
		double right_x = 0.5*getWidth()+HIP_WIDTH;
		GLine upperLeg = new GLine(left_x, upper_y, right_x, upper_y);
		GLine lowerLeg = new GLine(left_x, upper_y, left_x, lower_y);
		add(upperLeg);
		add(lowerLeg);	
	}
	
	private void addLeftFoot() {
		double right_x = 0.5*getWidth()-HIP_WIDTH;
		double left_x = right_x-FOOT_LENGTH;
		double y = 0.05*getHeight()-ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH;
		GLine leftFoot = new GLine(left_x, y, right_x, y);
		add(leftFoot);
	}
	
	private void addRightFoot() {
		double left_x = 0.5*getWidth()+HIP_WIDTH;
		double right_x = left_x+FOOT_LENGTH;
		double y = 0.05*getHeight()-ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH;
		GLine rightFoot = new GLine(left_x, y, right_x, y);
		add(rightFoot);
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
	private GLabel wordLabel;
	private GLabel incoLabel;
	int n = 7;

}
