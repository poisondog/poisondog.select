/*
 * Copyright (C) 2015 Adam Huang <poisondog@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package poisondog.select;

import java.util.List;
import java.util.Random;

/**
 * 輪盤選擇法
 * @author Adam Huang
 */
public class Roulette implements Selector {
	private Random mRandom;

	/**
	 * Constructor
	 */
	public Roulette() {
		mRandom = new Random();
	}

	/**
	 * Constructor
	 */
	public Roulette(long seed) {
		mRandom = new Random(seed);
	}

	@Override
	public Ball execute(List<Ball> participants) {
		double sum = 0;
		for (int i = 0; i < participants.size(); i++) {
			sum += ((Ball) participants.get(i)).getKey();
		}
		double index = mRandom.nextDouble() * sum;
		double current = 0;
		for (int i = 0; i < participants.size(); i++) {
			current += (participants.get(i)).getKey();
			if (current > index) {
				return participants.get(i);
			}
		}
		return participants.get(participants.size() - 1);
	}
}
