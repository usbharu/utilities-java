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

public class StringUtils {

  private StringUtils() {
  }

  public static int length(String str) {
    if (str == null) {
      return 0;
    }
    return str.length();
  }

  public static boolean isEmpty(String str) {
    if (str == null) {
      return true;
    }
    return str.isEmpty();
  }

  public static boolean isBlank(String str) {
    if (str == null) {
      return true;
    }
    return str.isBlank();
  }

  public static boolean isEquals(String str1, String str2) {
    if (str1 == null && str2 == null) {
      return true;
    }
    if (str1 == null || str2 == null) {
      return false;
    }
    return str1.equals(str2);
  }

  public static boolean equalToOneOf(String a, String... bs) {
    for (String b : bs) {
      if (a.equals(b)) {
        return true;
      }
    }
    return false;
  }

  public static String lastSubstring(String str, int index) {
    return str.substring(0, index);
  }

  /**
   * Remove all empty strings from the given array.
   *
   * @param strings the array to be cleaned
   * @return the cleaned array
   */
  public static String[] removeEmptyStrings(String[] strings) {
    if (strings == null) {
      return new String[0];
    }
    int size = strings.length;
    int newSize = 0;
    for (String s : strings) {
      if (s != null && s.length() > 0) {
        newSize++;
      }
    }
    if (newSize == size) {
      return strings;
    }
    String[] newString = new String[newSize];
    int j = 0;
    for (String s : strings) {
      if (s != null && s.length() > 0) {
        newString[j++] = s;
      }
    }
    return newString;
  }
}
