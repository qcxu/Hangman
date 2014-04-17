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
    	rgen.setSeed(0);
    	int no = rgen.nextInt(0, rl.getWordCount()-1);
    	String word = rl.getWord(no);
    	
    	/* Start to play the game */
    	dash = "";
    	for (int i = 0; i < word.length(); i++) {
    		dash += "-";
    	}
    	while (true) {
    		println("The word now looks like this " + dash);
    		println("You have " + count + " guesses left.");
    		str = readLine("Your guess: ");
    		
    		// Check to see whether the user guesses something other than a single letter
    		while (!isLetter(str)) {
    			println("The guess is illegal, try a new guess!");
    			str = readLine("Your guess: ");
    		}
    		
    		// Check to see whether the letter is in the word
    		dash = dashWithLetters(ch, word, dash);
    		
    		// Check to see whether win or lose
    		if (CorrectCount == word.length()) {
    			println("You guessed the word: " + word);
    			println("You win.");
    			break;
    		}
    		if (count == 0) {
    			println("You are completely hung.");
    			println("The word was: " + word);
    			println("You lose.");
    			break;
    		}
    	}
    		
    }
    
    /* Check whether the user guess is a single letter, which means it 
     * meets the following conditions:
     * (1) length is 1;
     * (2) convert it to a char;
     * (3) it is a letter;
     */
	private boolean isLetter(String str) {
		if (str.length() == 1) {
			ch = str.charAt(0);
			if (Character.isLetter(ch)) {
				return true;
			}
		}
		return false;
	}
	
	/* Check whether the guess letter is in the word which means it meets
	 * the following conditions:
	 * (1) convert it to upper case;
	 * (2) if it's in the word, replace that position with the letter;
	 * (3) if it's not in the word, no change.
	 */
	private String dashWithLetters(char ch, String word, String dash) {
		String result = "";
		int flag = 0;
		if (Character.isLowerCase(ch)) {
			ch = Character.toUpperCase(ch);
		}
		for (int i = 0; i < word.length(); i++) {
			if (ch == word.charAt(i)) {
				result += ch;
				CorrectCount += 1;
				flag = 1;
			} else {
				result += dash.charAt(i);
			}
		}
		if (flag == 0) {
			count -=1;
			println("There are no " + ch + "'s in the word.");
		}  else {
			println("That guess is correct.");
		}
		return result;
	}

    
    /* Instant variables */
    private RandomGenerator rgen = RandomGenerator.getInstance();
    String dash;
    int count = 8;
    String str;
    char ch;
    int CorrectCount = 0;
}
