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
		
		SelectEntity s1 = new SelectEntity(0, 1);
		SelectEntity s2 = new SelectEntity(1, 30);
		SelectEntity s3 = new SelectEntity(2, 60);
		SelectEntity s4 = new SelectEntity(3, 90);

		List<SelectEntity> list = new ArrayList<SelectEntity>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);

		for (int i = 0; i < 100; i++) {
			Assert.assertEquals(s4, selection.execute(list));
		}
	}
}
