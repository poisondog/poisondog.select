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

import java.util.Comparator;
/**
 * 以遞增的方式排序。
 * @author Adam Huang <poisondog@gmail.com>
 */
public class Increment implements Comparator<SelectEntity> {

	/**
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * @if(o1.fitness>o2.fitness) return 1
	 * @if(o1.fitness<o2.fitness) return -1
	 * @if(o1.fitness==o2.fitness) return 0
	 */
	@Override
	public int compare(SelectEntity o1, SelectEntity o2) {
		if (o1.getKey() < o2.getKey())
			return -1;
		else if (o1.getKey() > o2.getKey())
			return 1;
		return 0;
	}

}
