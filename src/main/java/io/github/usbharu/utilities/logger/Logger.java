package io.github.usbharu.utilities.logger;

import io.github.usbharu.utilities.ArrayUtils;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public interface Logger {

  default void log(String log, String location, int level) {
    log(log, location, Level.intToLevel(level));
  }

  default void log(String log, String location, Level level) {
    if (getPrintLevel() <= level.getLevel()) {
      getPrintWriter().println(
          new StringBuilder().append("[").append(level).append("] ").append(LocalDateTime.now())
              .append(" ").append(location).append(" ").append(log).toString());
    }
  }

  default void log(int level, Object... objects) {
    log(ArrayUtils.ObjectArrayToString(objects), getLocation(), level);
  }

  default void log(Level level, Object... objects) {
    log(ArrayUtils.ObjectArrayToString(objects), getLocation(), level);
  }

  default void debug(Object... objects) {
    log(ArrayUtils.ObjectArrayToString(objects), getLocation(), Level.DEBUG);
  }

  default void info(Object... objects) {
    log(ArrayUtils.ObjectArrayToString(objects), getLocation(), Level.INFO);
  }

  default void trace(Object... objects) {
    log(ArrayUtils.ObjectArrayToString(objects), getLocation(), Level.TRACE);
  }

  default void warn(Object... objects) {
    log(ArrayUtils.ObjectArrayToString(objects), getLocation(), Level.WARN);
  }

  default void error(Object... objects) {
    log(ArrayUtils.ObjectArrayToString(objects), getLocation(), Level.ERROR);
  }

  default void fatal(Object... objects) {
    log(ArrayUtils.ObjectArrayToString(objects), getLocation(), Level.FATAL);
  }

  String getLocation();

  int getPrintLevel();

  PrintWriter getPrintWriter();
}