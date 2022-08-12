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

package io.github.usbharu.utilities;

public class ClassNameFormatter {

  public static String format(Class<?> clazz) {
    String simpleName = clazz.getSimpleName();
    char[] chars = clazz.getName().toCharArray();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(chars[0]);
    for (int i = 0, charsLength = chars.length - simpleName.length(); i < charsLength; i++) {
      char c = chars[i];
      if (c == '.') {
        stringBuilder.append(c);
        if (charsLength > (i + 1)) {
          stringBuilder.append(chars[i + 1]);
        }
      }
    }
    stringBuilder.append(simpleName);
    return stringBuilder.toString();
  }
}
