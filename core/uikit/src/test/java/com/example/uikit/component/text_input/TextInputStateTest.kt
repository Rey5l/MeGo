package com.example.uikit.component.text_input

import com.example.uikit.components.text_input.TextInputState
import org.junit.Assert.assertNotEquals
import org.junit.Test

class TextInputStateTest {

    @Test
    fun statesAreDifferentInstances() {
        assertNotEquals(TextInputState.Default, TextInputState.Focused)
        assertNotEquals(TextInputState.Default, TextInputState.Warning)
        assertNotEquals(TextInputState.Default, TextInputState.Error)
        assertNotEquals(TextInputState.Default, TextInputState.Disabled)
    }
}

