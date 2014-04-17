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
    	
    	/* Play the game */
    	dash = "";
    	for (int i = 0; i < word.length(); i++) {
    		dash += "-";
    	}
    	while (true) {
    		println("The word now looks like this " + dash);
    		println("You have " + count + " guesses left.");
    		str = readLine("Your guess: ");
    		// If the user guesses something other than a single letter
    		while (!isLetter(str)) {
    			println("The guess is illegal, try a new guess!");
    			str = readLine("Your guess: ");
    		}
    		// If the letter in the word
    		dashWithLetters(ch, word, dash);
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
    
    /* If the user guess is a single letter */
	private boolean isLetter(String str) {
		if (str.length() == 1) {
			ch = str.charAt(0);
			if (Character.isLetter(ch)) {
				return true;
			}
		}
		return false;
	}
	
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
