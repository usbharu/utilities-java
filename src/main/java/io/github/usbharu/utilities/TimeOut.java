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

package io.github.usbharu.utilities;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TimeOut {

  public static void with(Runnable runnable)
      throws ExecutionException, InterruptedException, TimeoutException {
    with(runnable, 1000);
  }

  public static void with(Runnable runnable, long timeout) throws InterruptedException,
      ExecutionException, TimeoutException {
    with(runnable, timeout, TimeUnit.MILLISECONDS);
  }

  public static void with(Runnable runnable, long timeout, TimeUnit unit)
      throws InterruptedException,
      ExecutionException, TimeoutException {
    ExecutorService es = Executors.newSingleThreadExecutor();
    Future<?> future = es.submit(runnable);
    future.get(timeout, unit);
  }
}
