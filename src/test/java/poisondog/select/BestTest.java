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

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testGetWinner() throws Exception {
		Best selection = new Best();
		
		Ball s1 = new Ball(0, 1);
		Ball s2 = new Ball(1, 30);
		Ball s3 = new Ball(2, 60);
		Ball s4 = new Ball(3, 90);

		List<Ball> list = new ArrayList<Ball>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);

		for (int i = 0; i < 100; i++) {
			Assert.assertEquals(s4, selection.execute(list));
		}
	}
}
