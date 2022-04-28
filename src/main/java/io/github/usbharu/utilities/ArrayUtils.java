package io.github.usbharu.utilities;

public class ArrayUtils {

  private ArrayUtils() {
  }

  public static String ObjectArrayToString(Object... objects) {
    StringBuilder stringBuilder = new StringBuilder();
    for (Object object : objects) {
      stringBuilder.append(object);
    }
    return stringBuilder.toString();
  }
}