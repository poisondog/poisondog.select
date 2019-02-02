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
 * @author Adam Huang
 * @since 2009-05-12
 */
public class RouletteTest {
	private Selector mSelector;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mSelector = new Roulette();
	}

	@Test
	public void testSelection() {
		List<Ball> list = new ArrayList<Ball>();
		list.add(new Ball(0,10));
		list.add(new Ball(1,40));
		list.add(new Ball(2,60));
		list.add(new Ball(3,90));
		
		int[] ints=new int[4];
		for (int i = 0; i < 10000000; i++) {
			Ball winner = mSelector.execute(list);
			int k=Integer.parseInt(((Ball)winner).getEntity().toString());
			ints[k]++;
		}

		Assert.assertEquals(0.05,ints[0]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.2,ints[1]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.3,ints[2]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.45,ints[3]/10000000.0,Math.pow(10, -3));
	}

	@Test
	public void testAverageRunTime() throws Exception {
		List<Ball> list = new ArrayList<Ball>();
		list.add(new Ball(0,1));
		list.add(new Ball(1,1));
		list.add(new Ball(2,1));
		list.add(new Ball(3,1));
		list.add(new Ball(4,1));

		double sum = 0;
		int count = 0;
		for (int i = 0; i < 10000000; i++) {
			long start = System.currentTimeMillis();
			mSelector.execute(list);
			sum += System.currentTimeMillis() - start;
			count++;
		}
		System.out.println("average time:" + sum / count);
	}
}
