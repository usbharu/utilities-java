package io.github.usbharu.utilities.logger;

import io.github.usbharu.utilities.ClassNameFormatter;
import java.io.PrintWriter;

public class Logging {

  String location;
  int printLevel;
  PrintWriter printWriter;

  private Logging() {
  }

  public static LoggingBuilder builder() {
    return new LoggingBuilder();
  }

  public static Logger getLogger(String location, int printLevel, PrintWriter printWriter) {
    return SimpleLogger.getLogger(location, printLevel, printWriter);
  }

  public static Logger getLogger(Class<?> clazz) {
    return builder().location(clazz).build();
  }

  static class LoggingBuilder {

    String location;
    int printLevel;
    PrintWriter printWriter;

    private LoggingBuilder() {
      location = "";
      printLevel = Level.INFO.getLevel();
      printWriter = new PrintWriter(System.out, true);
    }

    public LoggingBuilder location(String location) {
      this.location = location;
      return this;
    }

    public LoggingBuilder location(Class<?> clazz) {
      this.location = ClassNameFormatter.format(clazz);
      return this;
    }

    public LoggingBuilder printLevel(Level level) {
      this.printLevel = level.getLevel();
      return this;
    }

    public LoggingBuilder printLevel(int printLevel) {
      this.printLevel = printLevel;
      return this;
    }

    public LoggingBuilder printWriter(PrintWriter printWriter) {
      this.printWriter = printWriter;
      return this;
    }

    public Logger build() {
      return Logging.getLogger(location, printLevel, printWriter);
    }

  }


}