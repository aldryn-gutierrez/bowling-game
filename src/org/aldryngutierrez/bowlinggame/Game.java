package org.aldryngutierrez.bowlinggame;

public class Game {
	
	private int score = 0;
	private int[] frameScore = new int[10];
	
	private int[] rolls = new int[21];
	private int currentRoll = 0;
		
	protected void roll(int pins){
		rolls[currentRoll++] = pins;
	}
	
	/**
	 * This function generate the Final and Frame Score
	 * using the rolls array
	 * 
	 */
	public int getScore()
	{
		int rollIndex = 0;
		for (int frame = 0; frame < 10; frame++, rollIndex += 2) {
			
			if (isStrike(rollIndex)){
				score += 10 + strikeBonus(rollIndex);
				rollIndex--;
			}else if (isSpare(rollIndex)){
				score += 10;
			}else {
				score += sumOfRollInFrame(rollIndex);
			}
				
			frameScore[frame] = score;
		}
		
		return this.score;
	}
	
	private boolean isStrike(int rollIndex) {
		return rolls[rollIndex] == 10;
	}

	private int strikeBonus(int rollIndex) {
		return rolls[rollIndex + 1] + rolls[rollIndex + 2];
	}

	public int sumOfRollInFrame(int rollIndex){
		return rolls[rollIndex] + rolls[rollIndex + 1];
	}
	
	public boolean isSpare(int rollIndex){
		return rolls[rollIndex] + rolls[rollIndex + 1] == 10 ;
	}
	
	public int spareBonus(int rollIndex){
		return rolls[rollIndex + 2];
	}
	
	public int[] getFrameScore() {
		return frameScore;
	}


}
