/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

    public void run() {
		/* You fill this in */
    	println("Welcome to Hangman!");
    	
    	/* Randomly choose a word from Hangman Lexicon */
    	HangmanLexicon rl = new HangmanLexicon();
    	int no = rgen.nextInt(0, rl.getWordCount()-1);
    	String word = rl.getWord(no);
    	println(word);
	}

    
    /* Instant variables */
    private RandomGenerator rgen = RandomGenerator.getInstance();
}
