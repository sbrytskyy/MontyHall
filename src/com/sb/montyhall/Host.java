package com.sb.montyhall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Host {

	private final List<Integer> doors = new ArrayList<>();

	private final Random r = new Random();

	private final Integer car;

	public Host() {
		// Add three doors
		doors.add(1);
		doors.add(2);
		doors.add(3);

		// Set car behind one of the door
		car = r.nextInt(3) + 1;
		doors.remove(car);
	}

	/**
	 * Accept first guess from User, but do not tell him result
	 * @param guess1
	 */
	public void guess1(Integer guess1) {
		doors.remove(guess1);
	}

	/**
	 * Reveal door, which is different then 1 user choice and which does't hide the car
	 * @return
	 */
	public Integer reveal() {
		int index = r.nextInt(doors.size());
		Integer reveal = doors.remove(index);
		return reveal;
	}

	/**
	 * Accept the second User's choice and say result
	 * @param guess2
	 * @return
	 */
	public boolean guess2(Integer guess2) {
		return guess2 == car;
	}

	/*------------------- JUST FOR DEBUG ----------------------------*/
	int getCar() {
		return car;
	}

	void print() {
		System.out.println(car + " : " + doors);
	}
}
