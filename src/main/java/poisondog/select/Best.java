/*
 * Copyright (C) 2011 Adam Huang <poisondog@gmail.com>
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Adam Huang <poisondog@gmail.com>
 */
public class Best implements Selector {
	private Random mRandom;
	private double mRate;

	/**
	 * Constructor
	 */
	public Best() {
		mRandom = new Random();
		mRate = 1;
	}

	/**
	 * Constructor
	 */
	public Best(long seed) {
		mRandom = new Random(seed);
		mRate = 1;
	}

	public void setRate(double rate) {
		mRate = rate;
	}

	@Override
	public Ball execute(List<Ball> participants) {
		if (mRandom.nextDouble() > mRate) {
			int index = mRandom.nextInt(participants.size());
			return participants.get(index);
		}

		double top = Double.NEGATIVE_INFINITY;
		for (Ball ball : participants) {
			top = Math.max(top, ball.getKey());
		}

		ArrayList<Ball> ready = new ArrayList<Ball>();
		for (Ball ball : participants) {
			if (ball.getKey() == top)
				ready.add(ball);
		}
		return ready.get(mRandom.nextInt(ready.size()));
	}
}
