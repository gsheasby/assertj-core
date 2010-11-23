/*
 * Created on Sep 17, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.assertions.error;

import static junit.framework.Assert.assertEquals;
import static org.fest.assertions.error.DoesNotContain.doesNotContain;
import static org.fest.util.Arrays.array;
import static org.fest.util.Collections.*;

import org.fest.assertions.description.Description;
import org.fest.assertions.description.TextDescription;
import org.junit.Test;

/**
 * Tests for <code>{@link DoesNotContain#create(Description)}</code>.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class DoesNotContain_create_Test {

  private ErrorMessage errorMessage;

  @Test public void should_create_error_message_when_actual_is_Collection() {
    errorMessage = doesNotContain(list("Yoda"), array("Luke", "Yoda"), set("Luke"));
    assertThatErrorMessageIsCorrect();
  }

  @Test public void should_create_error_message_when_actual_is_array_of_Object() {
    errorMessage = doesNotContain(array("Yoda"), array("Luke", "Yoda"), set("Luke"));
    assertThatErrorMessageIsCorrect();
  }

  private void assertThatErrorMessageIsCorrect() {
    String message = errorMessage.create(new TextDescription("Test"));
    assertEquals("[Test] expected:<['Yoda']> to contain:<['Luke', 'Yoda']> but could not find:<['Luke']>", message);
  }
}
