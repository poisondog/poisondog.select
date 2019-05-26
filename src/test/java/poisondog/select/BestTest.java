//2011/11/3
/*******************************
 * BestTest.java
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
public class BestTest {
	private Best mSelector;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mSelector = new Best(10l);
		mSelector.setRate(0.9);
	}

	@Test
	public void testGetWinner() throws Exception {
		Ball s1 = new Ball(0, 10);
		Ball s2 = new Ball(1, 30);
		Ball s3 = new Ball(2, 60);
		Ball s4 = new Ball(3, 90);

		List<Ball> list = new ArrayList<Ball>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);

		int[] ints=new int[4];
		for (int i = 0; i < 10000000; i++) {
			Ball winner = mSelector.execute(list);
			int k=Integer.parseInt(((Ball)winner).getEntity().toString());
			ints[k]++;
		}

		Assert.assertEquals(0.0249411,ints[0]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.0249715,ints[1]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.0250296,ints[2]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.9250578,ints[3]/10000000.0,Math.pow(10, -3));
	}

	@Test
	public void testTwoTop() throws Exception {
		Ball s1 = new Ball(0, 10);
		Ball s2 = new Ball(1, 20);
		Ball s3 = new Ball(2, 30);
		Ball s4 = new Ball(3, 30);

		List<Ball> list = new ArrayList<Ball>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);

		int[] ints=new int[4];
		for (int i = 0; i < 10000000; i++) {
			Ball winner = mSelector.execute(list);
			int k=Integer.parseInt(((Ball)winner).getEntity().toString());
			ints[k]++;
		}

		Assert.assertEquals(0.0249411,ints[0]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.0249715,ints[1]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.4750211,ints[2]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.4749921,ints[3]/10000000.0,Math.pow(10, -3));
	}

	@Test
	public void testAllZero() throws Exception {
		Ball s1 = new Ball(0, 0);
		Ball s2 = new Ball(1, 0);
		Ball s3 = new Ball(2, 0);
		Ball s4 = new Ball(3, 0);

		List<Ball> list = new ArrayList<Ball>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);

		int[] ints=new int[4];
		for (int i = 0; i < 10000000; i++) {
			Ball winner = mSelector.execute(list);
			int k=Integer.parseInt(((Ball)winner).getEntity().toString());
			ints[k]++;
		}

		Assert.assertEquals(0.2499391,ints[0]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.2500677,ints[1]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.2501892,ints[2]/10000000.0,Math.pow(10, -3));
		Assert.assertEquals(0.249804,ints[3]/10000000.0,Math.pow(10, -3));
	}
}
