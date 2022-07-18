package io.github.usbharu.utilities.logger;

import java.io.PrintWriter;

public class SimpleLogger implements Logger {

  private final String location;
  private final PrintWriter printWriter;
  private final int printLevel;

  public SimpleLogger(String location, int printLevel, PrintWriter printWriter) {
    this.location = location;
    this.printWriter = printWriter;
    this.printLevel = printLevel;
  }

  public static SimpleLogger getLogger(String location, int printLevel, PrintWriter printWriter) {
    return new SimpleLogger(location, printLevel, printWriter);
  }

  public String getLocation() {
    return location;
  }

  @Override
  public int getPrintLevel() {
    return printLevel;
  }


  @Override
  public PrintWriter getPrintWriter() {
    return printWriter;
  }


}