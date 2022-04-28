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