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
	private SelectEntity mEntity;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mEntity = new SelectEntity("Test", 123.7);
	}

	@Test
	public void test() {
		Assert.assertEquals("Test", mEntity.getEntity());
		Assert.assertEquals(123.7, mEntity.getKey());
	}

	@Test
	public void testDefaultValue() throws Exception {
		mEntity = new SelectEntity("Test");
		Assert.assertEquals("Test", mEntity.getEntity());
		Assert.assertEquals(1.0, mEntity.getKey());
	}
}
