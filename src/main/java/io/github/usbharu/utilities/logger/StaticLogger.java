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
