/*
 * Copyright (C) 2018 Adam Huang <poisondog@gmail.com>
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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Adam Huang
 * @since 2018-05-31
 */
public class DecrementTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCompare() throws Exception {
		ArrayList<SelectEntity> list = new ArrayList<SelectEntity>();
		list.add(new SelectEntity(0,10));
		list.add(new SelectEntity(1,30));
		list.add(new SelectEntity(2,60));
		list.add(new SelectEntity(3,90));
		list.add(new SelectEntity(4,30));

		Collections.sort(list, new Decrement());
		Assert.assertEquals(90, list.get(0).getKey(), Math.pow(10, -6));
		Assert.assertEquals(60, list.get(1).getKey(), Math.pow(10, -6));
		Assert.assertEquals(30, list.get(2).getKey(), Math.pow(10, -6));
		Assert.assertEquals(10, list.get(4).getKey(), Math.pow(10, -6));
	}
}
