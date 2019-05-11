package com.sb.montyhall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {

	private final List<Integer> doors = new ArrayList<>();

	private final Random r = new Random();

	private Integer guess1;

	public User() {
		// Add three doors
		doors.add(1);
		doors.add(2);
		doors.add(3);
	}

	/**
	 * Do first guess.
	 * It will be same door in case of non switching strategy
	 * @return
	 */
	public Integer guess1() {
		guess1 = r.nextInt(3) + 1;
		doors.remove(guess1);
		return guess1;
	}

	/**
	 * See which door is revelaed by Host
	 * @param reveal
	 */
	public void seeRevealedDoor(Integer reveal) {
		if (reveal < 1 || reveal > 3) {
			throw new IllegalArgumentException();
		}

		doors.remove(reveal);
	}

	/**
	 * Do the second guess in switching strategy only
	 * @return
	 */
	public Integer guess2() {
		int index = r.nextInt(doors.size());
		Integer guess2 = doors.remove(index);
		return guess2;
	}

}
