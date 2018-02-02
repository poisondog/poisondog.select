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

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Adam Huang
 * @since 2009-06-17
 */
public class SelectEntityTest {

	private SelectEntity ds;
	private String title;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		title = new String("Test");
		ds = new SelectEntity(title,123.7);
	}

	@Test
	public void test() {
		Assert.assertEquals(title,ds.getEntity());
		Assert.assertEquals(123.7,ds.getKey());
	}
}
