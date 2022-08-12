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
