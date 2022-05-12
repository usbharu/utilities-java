package io.github.usbharu.utilities;

public class StringUtils {

  private StringUtils() {
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