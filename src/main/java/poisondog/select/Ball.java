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

/**
 * 基礎的可選擇元素，用以簡單實現簡單的選擇機制。
 * @author Adam Huang
 */
public class Ball  {

	private final double key;
	private final Object object;

	/**
	 * Constructors.<br>
	 * Notice! the key is more bigger more better.
	 */
	public Ball(Object object, double key) {
		this.object = object;
		this.key = key;
	}

	/**
	 * Constructor
	 */
	public Ball(Object object) {
		this(object, 1.0);
	}

	public Object getEntity() {
		return object;
	}

	public double getKey() {
		return key;
	}
}
