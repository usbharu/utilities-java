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

}