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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 排名選擇法
 * @author Adam Huang
 */
public class Ranking implements Selector {
	private Comparator<SelectEntity> mComparator;
	private Random mRandom;

	public Ranking() {
		mComparator = new Increment();
		mRandom = new Random();
	}

	/**
	 * Constructor
	 */
	public Ranking(long seed) {
		mComparator = new Increment();
		mRandom = new Random(seed);
	}

	@Override
	public SelectEntity execute(List<SelectEntity> participants) {
		Collections.sort(participants, mComparator);
		double sum = 0;
		for (int i = 0; i < participants.size(); i++) {
			sum += (i + 1);
		}
		double index = mRandom.nextDouble() * sum;
		double current = 0;
		for (int i = 0; i < participants.size(); i++) {
			current += (i + 1);
			if (current > index) {
				return participants.get(i);
			}
		}
		return null;
	}
}
