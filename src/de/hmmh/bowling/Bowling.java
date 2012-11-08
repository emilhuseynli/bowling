package de.hmmh.bowling;

public class Bowling {
	
	private static final int MAX_THROWS = 21;
	private static final int MAX_ROUNDS = 10;
	
	private int[] _throws = new int[MAX_THROWS];
	
	private int currThrowId = 0;
	
	// add a next throw to throws array
	public void addThrow(int pins) {
		if (currThrowId >= MAX_THROWS) {
			throw new RuntimeException("Maximum allowed throws count exceeded");
		}
		_throws[currThrowId++] = pins; 
	}
	
	// calculate score for specified round
	public int getScore(int round) {
		if (round < 1 || round > MAX_ROUNDS) {
			throw new RuntimeException("Round number out of bounds");
		}
		
		int score = 0;
		int currRound = 0;
		
		for (int i = 0; i < _throws.length && currRound++ < round;) {
			if (_throws[i] == 10) { // strike
				score += 10 + _throws[i + 1] + _throws[i + 2];
				i++;
			} else if ((_throws[i] + _throws[i+1]) == 10) { // spare
				score += 10 + _throws[i + 2];
				i += 2;
			} else {
				score += _throws[i] + _throws[i+1];

				i += 2;
			}
		}

		return score;
	}
	
}
