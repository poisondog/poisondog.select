//2011/4/12
/*******************************
 * InverseRouletteTest.java
 *******************************/
package poisondog.select;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author poisondog
 *
 */
public class InverseRouletteTest {

	private InverseRoulette selection;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		selection = new InverseRoulette();
	}

	@Test
	public void testSelection() throws Exception {
		List<Ball> list = new ArrayList<Ball>();
		list.add(new Ball(0,10));
		list.add(new Ball(1,40));
		list.add(new Ball(2,60));
		list.add(new Ball(3,90));
		
		int[] ints=new int[4];
		for (int i = 0; i < 10000000; i++) {
			Ball winner = selection.execute(list);
			int k=Integer.parseInt(((Ball)winner).getEntity().toString());
			ints[k]++;
		}

		Assert.assertEquals(0.65454545,ints[0]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.16363636,ints[1]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.10909090,ints[2]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.07272727,ints[3]/10000000.0,Math.pow(10, -3));
	}
}
