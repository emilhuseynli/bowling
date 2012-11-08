package de.hmmh.bowling.test;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hmmh.bowling.Bowling;

public class MainTestCase {

	@Test
	public void testFullGame() {
		Bowling bowling = new Bowling();

		// round 1
		bowling.addThrow(1);
		bowling.addThrow(4);
		
		assertEquals(5, bowling.getScore(1)); // round 1 score
		
		// round 2		
		bowling.addThrow(4);
		bowling.addThrow(5);
		
		assertEquals(14, bowling.getScore(2)); // round 2 score		
		
		// round 3 (spare)
		bowling.addThrow(6);
		bowling.addThrow(4);
		
		assertEquals(24, bowling.getScore(3)); // round 3 score without spare bonus		
		
		// round 4	(spare)	
		bowling.addThrow(5);
		
		assertEquals(29, bowling.getScore(3)); // round 3 score with spare bonus 5
		
		bowling.addThrow(5);
		
		assertEquals(39, bowling.getScore(4)); // round 4 score without spare bonus		
		
		// round 5 (strike)
		bowling.addThrow(10);

		assertEquals(49, bowling.getScore(4)); // round 4 score with spare bonus 10
		
		assertEquals(59, bowling.getScore(5)); // round 5 score without strike bonus
		
		// round 6
		bowling.addThrow(0);
		bowling.addThrow(1);
		
		assertEquals(60, bowling.getScore(5)); // round 5 score with strike bonus 1
		
		assertEquals(61, bowling.getScore(6)); // round 6 score
		
		// round 7 (spare)
		bowling.addThrow(7);
		bowling.addThrow(3);
		
		assertEquals(71, bowling.getScore(7)); // round 7 score without spare bonus
		
		// round 8 (spare)
		bowling.addThrow(6);
		
		assertEquals(77, bowling.getScore(7)); // round 7 score with spare bonus 6
		
		bowling.addThrow(4);
		
		assertEquals(87, bowling.getScore(8)); // round 8 score without spare bonus		
		
		// round 9 (strike)
		bowling.addThrow(10);
		
		assertEquals(97, bowling.getScore(8)); // round 8 score with spare bonus 10
		
		assertEquals(107, bowling.getScore(9)); // round 9 score without strike bonus
		
		// round 10 (spare)
		bowling.addThrow(2);
		bowling.addThrow(8);
		
		assertEquals(117, bowling.getScore(9)); // round 9 score with strike bonus (2+8)
		
		assertEquals(127, bowling.getScore(10)); // round 10 score without spare bonus 		
		
		bowling.addThrow(6);
	
		assertEquals(133, bowling.getScore(10)); // round 10 score with spare bonus 6
	}

}
