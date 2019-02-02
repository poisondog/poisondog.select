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

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Adam Huang
 * @since 2010-05-09
 */
public class TournamentTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelection() throws Exception {
		Ball best = new Ball(1, 3);
		List<Ball> list = new ArrayList<Ball>();
		list.add(new Ball(0, 2));
		list.add(best);

		Tournament selection = new Tournament(2);
		Ball winner = selection.execute(list);
		Assert.assertEquals(best, winner);
	}

	/**
	 * test when range bigger then participants from tournament selection.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSelection2() throws Exception {
		Ball e1 = new Ball("1", 3);
		Ball e2 = new Ball("2", 4);
		Ball e3 = new Ball("3", 5);

		List<Ball> list = new ArrayList<Ball>();
		list.add(e1);
		list.add(e2);
		list.add(e3);

		Selector selection = new Tournament(10);
		Ball winner = selection.execute(list);
		Assert.assertEquals(e3, winner);
	}

	/**
	 * test double select from tournament selection.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDoubleSelection() throws Exception {
		Ball e1 = new Ball("1", 3);
		Ball e2 = new Ball("2", 4);
		Ball e3 = new Ball("3", 5);

		List<Ball> list = new ArrayList<Ball>();
		list.add(e1);
		list.add(e2);
		list.add(e3);

		Selector selection = new Tournament(10);
		Ball r1 = selection.execute(list);
		Ball r2 = selection.execute(list);

		Assert.assertEquals(e3, r1);
		Assert.assertEquals(e3, r2);
	}
}
