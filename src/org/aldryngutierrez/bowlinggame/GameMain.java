package org.aldryngutierrez.bowlinggame;


public class GameMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game bowlingGame = new Game();
		
		int[][] shots = InputHelper.generateShotInput();
		shootPins(bowlingGame, shots);
		bowlingGame.getScore();	
		displayFrameScore(bowlingGame.getFrameScore());
	}
	
	/**
	 * This Function Receives the shots which is a 2D array
	 * From the Game Object passed, it will roll the shots from
	 * the 2D Array
	 */
	public static void shootPins(Game game, int[][] shots) {
	  for(int row = 0; row < shots.length; row++) {
	     for(int col = 0; col < shots[row].length; col++) {
	    	game.roll(shots[row][col]);
	     }
	  }
	}
	
	/**
	 * This Function Displays the Frame Score for each Frame
	 */
	public static void displayFrameScore(int[] frameScore){
		String output = "";
		for(int fs : frameScore){
			output += "[" + fs + "]";
		}
		
		System.out.println(output);
	}

}
