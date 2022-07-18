package io.github.usbharu.utilities.logger;


public class StaticLogger {

  private static final Logger logger =
      Logging.builder().location("static").printLevel(Level.DEBUG).build();

  private StaticLogger() {
  }

  public static void trace(Object... objects) {
    logger.trace(objects);
  }

  public static void debug(Object... objects) {
    logger.debug(objects);
  }

  public static void info(Object... objects) {
    logger.info(objects);
  }

  public static void warn(Object... objects) {
    logger.warn(objects);
  }

  public static void error(Object... objects) {
    logger.error(objects);
  }

  public static void fatal(Object... objects) {
    logger.fatal(objects);
  }

}