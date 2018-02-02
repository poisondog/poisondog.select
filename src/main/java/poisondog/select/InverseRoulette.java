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

/**
 * @author Adam Huang
 */
public class InverseRoulette implements Selector {
	private Roulette mRoulette;

	public InverseRoulette() {
		mRoulette = new Roulette();
	}

	/**
	 * Constructor
	 */
	public InverseRoulette(long seed) {
		mRoulette = new Roulette(seed);
	}

	@Override
	public SelectEntity execute(List<SelectEntity> participants) {
		double max = 0;
		for (SelectEntity entity : participants) {
			if (entity.getKey() > max)
				max = entity.getKey();
		}
		List<SelectEntity> temp = new ArrayList<SelectEntity>(participants.size());
		for (SelectEntity entity : participants) {
			temp.add(new SelectEntity(entity.getEntity(), max / entity.getKey()));
		}
		return mRoulette.execute(temp);
	}
}
