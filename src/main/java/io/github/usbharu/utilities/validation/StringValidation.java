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

import java.util.Objects;

public interface StringValidation {

  StringValidation STRING_VALIDATION = new StringValidation() {
  };

  default String nonNullAndNonBlank(String str, String message) {
    if (str == null) {
      throw new NullPointerException(message);
    }
    if (str.isBlank()) {
      throw new IllegalArgumentException(message);
    }
    return str;
  }

  default String nonNullAndNonBlank(String str) {
    if (str == null) {
      throw new NullPointerException();
    }
    if (str.isBlank()) {
      throw new IllegalArgumentException();
    }
    return str;
  }

  default String nonNullAndNonEmpty(String str) {
    if (str == null) {
      throw new NullPointerException();
    }
    if (str.isEmpty()) {
      throw new IllegalArgumentException();
    }
    return str;
  }

  default String nonNullAndNonEmpty(String str, String message) {
    if (str == null) {
      throw new NullPointerException(message);
    }
    if (str.isEmpty()) {
      throw new IllegalArgumentException(message);
    }
    return str;
  }

  default String empty(String str) {
    if (str == null) {
      return "";
    }
    if (!str.isEmpty()) {
      throw new IllegalArgumentException();
    }
    return str;
  }

  default String blank(String str) {
    if (str == null) {
      return "";
    }
    if (!str.isBlank()) {
      throw new IllegalArgumentException();
    }
    return str;
  }

  default String length(String str, int length) {
    if (Objects.requireNonNull(str).length() == length) {
      return str;
    }
    throw new IllegalArgumentException();
  }

  default String length(String str, int length, String message) {
    if (Objects.requireNonNull(str).length() == length) {
      return str;
    }
    throw new IllegalArgumentException(message);
  }

  default String lengthLessThan(String str, int length) {
    if (Objects.requireNonNull(str).length() < length) {
      return str;
    }
    throw new IllegalArgumentException();
  }

  default String lengthLessThan(String str, int length, String message) {
    if (Objects.requireNonNull(str).length() < length) {
      return str;
    }
    throw new IllegalArgumentException(message);
  }

  default String lengthLessThanOrEqual(String str, int length) {
    if (Objects.requireNonNull(str).length() <= length) {
      return str;
    }
    throw new IllegalArgumentException();
  }

  default String lengthLessThanOrEqual(String str, int length, String message) {
    if (Objects.requireNonNull(str).length() <= length) {
      return str;
    }
    throw new IllegalArgumentException(message);
  }

  default String lengthGreaterThan(String str, int length) {
    if (Objects.requireNonNull(str).length() > length) {
      return str;
    }
    throw new IllegalArgumentException();
  }

  default String lengthGreaterThan(String str, int length, String message) {
    if (Objects.requireNonNull(str).length() > length) {
      return str;
    }
    throw new IllegalArgumentException(message);
  }

  default String lengthGreaterThanOrEqual(String str, int length) {
    if (Objects.requireNonNull(str).length() >= length) {
      return str;
    }
    throw new IllegalArgumentException();
  }

  default String lengthGreaterThanOrEqual(String str, int length, String message) {
    if (Objects.requireNonNull(str).length() >= length) {
      return str;
    }
    throw new IllegalArgumentException(message);
  }

  default String lengthBetween(String str, int min, int max) {
    if (Objects.requireNonNull(str).length() >= min && str.length() <= max) {
      return str;
    }
    throw new IllegalArgumentException();
  }

  default String noSpaces(String str) {
    if (Objects.requireNonNull(str).contains(" ")) {
      throw new IllegalArgumentException();
    }
    return str;
  }

  default String no(String str, String str2) {
    if (Objects.requireNonNull(str).contains(str2)) {
      throw new IllegalArgumentException();
    }
    return str;
  }

}
