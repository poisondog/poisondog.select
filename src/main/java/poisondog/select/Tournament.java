/*
 * Copyright (C) 2010 Adam Huang <poisondog@gmail.com>
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

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Adam Huang
 */
public class Tournament implements Selector {
	private final int mRange;
	private Random mRandom;

	public Tournament(int range) {
		mRange = range;
		mRandom = new Random();
	}

	/**
	 * Constructor
	 */
	public Tournament(int range, long seed) {
		mRange = range;
		mRandom = new Random(seed);
	}

	@Override
	public SelectEntity execute(List<SelectEntity> participants) {
		SelectEntity best = null;
		List<SelectEntity> temp = new LinkedList<SelectEntity>();
		for (int i = 0; i < mRange; i++) {
			if (participants.size() <= 0)
				break;
			SelectEntity entity = participants.remove(mRandom.nextInt(participants.size()));
			temp.add(entity);
			if (best == null || best.getKey() < entity.getKey()) {
				best = entity;
			}
		}
		participants.addAll(temp);
		return best;
	}
}
