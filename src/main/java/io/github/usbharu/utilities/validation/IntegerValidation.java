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

package io.github.usbharu.utilities.validation;

public interface IntegerValidation {

  IntegerValidation INTEGER_VALIDATION = new IntegerValidation() {
  };

  default int positive(int number) {
    return positive(number, "");
  }

  default int positive(int number, String message) {
    if (number > 0) {
      return number;
    }
    throw new IllegalArgumentException(message);
  }

  default int positiveOrZero(int number) {
    return positiveOrZero(number, "");
  }

  default int positiveOrZero(int number, String message) {
    if (number >= 0) {
      return number;
    }
    throw new IllegalArgumentException(message);
  }

  default int negative(int number, String message) {
    if (number < 0) {
      return number;
    }
    throw new IllegalArgumentException(message);
  }

  default int negative(int number) {
    return negative(number, "");
  }

  default int negativeOrZero(int number, String message) {
    if (number <= 0) {
      return number;
    }
    throw new IllegalArgumentException(message);
  }

  default int negativeOrZero(int number) {
    return negativeOrZero(number, "");
  }
}
