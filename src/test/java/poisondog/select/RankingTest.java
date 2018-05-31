/*
 * Copyright (C) 2009 Adam Huang <poisondog@gmail.com>
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
 * @author Administrator
 * @since 2009-05-12
 */
public class RankingTest {
	private Selector mRanking;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mRanking = new Ranking(33l);
	}

	@Test
	public void testInstance() throws Exception {
		Assert.assertNotNull(new Ranking());
	}

	@Test
	public void testSelection() {
		List<SelectEntity> list = new ArrayList<SelectEntity>();
		list.add(new SelectEntity(0,1));
		list.add(new SelectEntity(1,30));
		list.add(new SelectEntity(2,60));
		list.add(new SelectEntity(3,90));
		
		int[] ints=new int[4];
		for (int i = 0; i < 1000000; i++) {
			SelectEntity winner = mRanking.execute(list);
			int k=Integer.parseInt(((SelectEntity)winner).getEntity().toString());
			ints[k]++;
		}
		
		Assert.assertEquals(0.1,ints[0]/1000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.2,ints[1]/1000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.3,ints[2]/1000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.4,ints[3]/1000000.0,Math.pow(10, -3));
	}

	@Test
	public void testSameValue() throws Exception {
		List<SelectEntity> list = new ArrayList<SelectEntity>();
		list.add(new SelectEntity(0,0));
		list.add(new SelectEntity(1,0));
		list.add(new SelectEntity(2,0));
		list.add(new SelectEntity(3,0));
		
		int[] ints=new int[4];
		for (int i = 0; i < 1000000; i++) {
			SelectEntity winner = mRanking.execute(list);
			int k=Integer.parseInt(((SelectEntity)winner).getEntity().toString());
			ints[k]++;
		}
		
		Assert.assertEquals(0.1,ints[0]/1000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.2,ints[1]/1000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.3,ints[2]/1000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.4,ints[3]/1000000.0,Math.pow(10, -3));
	}

	@Test
	public void testAverageRunTime() throws Exception {
		List<SelectEntity> list = new ArrayList<SelectEntity>();
		list.add(new SelectEntity(0,1));
		list.add(new SelectEntity(1,3));
		list.add(new SelectEntity(2,5));
		list.add(new SelectEntity(3,2));
		list.add(new SelectEntity(4,4));

		double sum = 0;
		int count = 0;
		for (int i = 0; i < 10000000; i++) {
			long start = System.currentTimeMillis();
			mRanking.execute(list);
			sum += System.currentTimeMillis() - start;
			count++;
		}
		System.out.println("average time:" + sum / count);
	}
}
