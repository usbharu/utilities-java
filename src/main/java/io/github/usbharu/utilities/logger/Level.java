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