/*
 * Copyright (C) 2018 Adam Huang <poisondog@gmail.com>
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

import java.util.List;
import poisondog.core.Mission;

/**
 * 選擇機制介面。
 * @author Adam Huang
 */
public interface Selector extends Mission<List<SelectEntity>> {
	/**
	 * 由參加者中，取得獲勝者
	 * @param participants 為參加者所構成的串列
	 * @return participants 中的勝利者
	 */
	public SelectEntity execute(List<SelectEntity> participants);
}
