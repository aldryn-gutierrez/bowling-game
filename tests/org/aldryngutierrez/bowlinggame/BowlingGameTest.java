package org.aldryngutierrez.bowlinggame;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingGameTest {
	
	public Game game = new Game();
	
	@Test
	public void testRollingOneScoresOne() throws Exception{
		game.roll(1);
		assertEquals(1, game.getScore());
	}
	
	@Test
	public void testRollingTwoScoresTwo() throws Exception{
		game.roll(2);
		assertEquals(2, game.getScore());
	}
	
	@Test
	public void testRollingOneThenOneScoresTwo() throws Exception {
		for(int i = 0; i < 2; i++){
			game.roll(1);
		}
		
		assertEquals(2, game.getScore());
	}
	
	@Test
	public void testRollingASpareThenAOneScoresEleven(){
		game.roll(5);
		game.roll(5);
		game.roll(1);
		assertEquals(11, game.getScore());
	}
	
	@Test
	public void testRollingOneThenOneThenSpareThenOneScoresThirteen() throws Exception{
		game.roll(1);
		game.roll(1);
		game.roll(5);
		game.roll(5);
		game.roll(1);
		assertEquals(13, game.getScore());
	}
	
	@Test
	public void testRollingStrikeThenOneThenOneScoresFourteen() throws Exception {
		game.roll(10);
		rollMany(2, 1);
		assertEquals(14, game.getScore());
	}
	
	@Test
	public void testRollingOneThenOneThenStrikeThenOneThenOneScoresSixteen() throws Exception {
		rollMany(2, 1);
		game.roll(10);
		rollMany(2, 1);
		assertEquals(16, game.getScore());
	}
	
	@Test
	public void testRollOneThenOneThenThreeStrikesThenRollOneThenOneScoresSixtySeven() throws Exception {
		rollMany(2, 1);
		game.roll(10);
		game.roll(10);
		game.roll(10);
		rollMany(2, 1);
		assertEquals(67, game.getScore());
	}
	
	public void rollMany(int numberOfRolls, int pins){
		for (int i = 0; i < numberOfRolls; i++){
			game.roll(pins);
		}
	}
	
}
