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
		SelectEntity best = new SelectEntity(1, 3);
		List<SelectEntity> list = new ArrayList<SelectEntity>();
		list.add(new SelectEntity(0, 2));
		list.add(best);

		Tournament selection = new Tournament(2, 10l);
		SelectEntity winner = selection.execute(list);
		Assert.assertEquals(best, winner);
	}

	/**
	 * test when range bigger then participants from tournament selection.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSelection2() throws Exception {
		SelectEntity e1 = new SelectEntity("1", 3);
		SelectEntity e2 = new SelectEntity("2", 4);
		SelectEntity e3 = new SelectEntity("3", 5);

		List<SelectEntity> list = new ArrayList<SelectEntity>();
		list.add(e1);
		list.add(e2);
		list.add(e3);

		Selector selection = new Tournament(10);
		SelectEntity winner = selection.execute(list);
		Assert.assertEquals(e3, winner);
	}

	/**
	 * test double select from tournament selection.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDoubleSelection() throws Exception {
		SelectEntity e1 = new SelectEntity("1", 3);
		SelectEntity e2 = new SelectEntity("2", 4);
		SelectEntity e3 = new SelectEntity("3", 5);

		List<SelectEntity> list = new ArrayList<SelectEntity>();
		list.add(e1);
		list.add(e2);
		list.add(e3);

		Selector selection = new Tournament(10);
		SelectEntity r1 = selection.execute(list);
		SelectEntity r2 = selection.execute(list);

		Assert.assertEquals(e3, r1);
		Assert.assertEquals(e3, r2);
	}
}
