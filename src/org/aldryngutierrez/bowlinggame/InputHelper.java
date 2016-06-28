package org.aldryngutierrez.bowlinggame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
	
	private static int[][] shots = new int[10][];
	private static int frameCount = 0;
	private static int lastShot = 0;
	private static boolean isSecondShot = false;
	private static int lastFrameStrikeCounter = 0;
	private static boolean lastFrameShotIsStrike = false;
	
	/**
	 * This Function Generates the 2D Array of Shots
	 * for the Bowling Game through User Input
	 * 
	 */
	public static int[][] generateShotInput()
	{
		while(true && frameCount != 10) {    
		    try {
		        System.out.println("Please enter a number: ");
		        Scanner scanner = new Scanner(System.in);
		        int currentShot = scanner.nextInt();
		        
		        if (isBetweenValidShotRange(currentShot)) {
		        	System.out.println("Please enter a number Greater Than 0 and Less Than 10 only");
		        	continue;
		        } else if (isValidStrike(isSecondShot, currentShot)) {
		        	System.out.println("Entered Strike Number is : " + currentShot);
		        	
		        	// If Frame Count is the last one
		        	// We need to check whether input are all strike
		        	// Else we just set the Shot of that Frame to a strike
		        	if (frameCount != 9) {
		        		shots[frameCount] = new int[]{10};
		        		frameCount++;
		        	} else {  		
		        		lastFrameShotIsStrike = true;	        		
		        		lastFrameStrikeCounter++;
		        		
		        		if (lastFrameStrikeCounter == 3) {
		        			shots[frameCount] = new int[]{10, 10, 10};    
		        			frameCount++;
		        		}
		        	}
		        	
			        continue;
		        } else {
		        	
		        	if (lastFrameStrikeCounter == 2){
		        		shots[frameCount] = new int[]{10, 10, currentShot};    
	        			frameCount++;
		        	}

		        	if (isSecondShot) {
		        		
		        		// If it is not a Valid Second Shot it means that it was higher than
		        		// the previous shot, so we continue asking for user input
		        		if (isValidSecondShot(currentShot, lastShot)) {
		        			System.out.println("Entered Second Number is : " + currentShot);
		        			
		        			if (lastFrameShotIsStrike) {
		        				shots[frameCount] = new int[]{10, lastShot, currentShot};
		        			} else {
		        				shots[frameCount] = new int[]{lastShot, currentShot};
		        			}
		        			
		        			lastShot = 0;
		        			isSecondShot = false;
		        			frameCount++;
		        		} 	        		
		        	} else {
		        		System.out.println("Entered First Number is : " + currentShot);
		        		isSecondShot = true;
		        		lastShot = currentShot;		 
		        	}
		        	continue;
		        }
		        
		    } catch(InputMismatchException | NumberFormatException ex ) {
		        System.out.println("\n\nInput was not a Whole Number. Please enter Whole Number again : ");
		    } catch(Exception e ) {
		        System.out.println("\n\nException caught :: " + e);
		    } 
		}
		
		return shots;
	}
	
	private static boolean isBetweenValidShotRange(int currentShot){
		return (currentShot < 0 || currentShot > 10 );
	}
	
	private static boolean isValidStrike(boolean isSecondShot, int currentShot){
		return (isSecondShot == false && currentShot == 10);
	}
	
	private static boolean isValidSecondShot(int currentShot, int lastShot){
		return (currentShot <= (10 - lastShot));
	}
	
	
}
