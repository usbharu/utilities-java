/*
 * Copyright 2022 usbharu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.usbharu.utilities.logger;

public enum Level {
  NONE(0),
  TRACE(1),
  DEBUG(2),
  INFO(3),
  WARN(4),
  ERROR(5),
  FATAL(6);

  private final int level;

  Level(int level) {
    this.level = level;
  }

  public static Level intToLevel(int level) {
    if (0 > level || level > values().length) {
      throw new IndexOutOfBoundsException();
    }
    for (Level value : values()) {
      if (value.getLevel() == level) {
        return value;
      }
    }
    throw new IllegalStateException();
  }

  public int getLevel() {
    return level;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(name());
    for (int i = 0; i < 5 - name().length(); i++) {
      stringBuilder.append(' ');
    }
    return stringBuilder.toString();
  }
}
