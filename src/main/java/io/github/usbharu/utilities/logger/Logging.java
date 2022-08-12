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
