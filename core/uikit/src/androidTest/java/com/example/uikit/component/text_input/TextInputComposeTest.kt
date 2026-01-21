package com.example.uikit.component.text_input

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onNode
import com.example.uikit.theme.UIKitTheme
import org.junit.Rule
import org.junit.Test

class TextInputComposeTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun showsLabelAndValue() {
        composeRule.setContent {
            UIKitTheme {
                TextInput(
                    value = "MeGo",
                    onValueChange = {},
                    label = "Label",
                    placeholder = "Placeholder",
                )
            }
        }

        composeRule.onNodeWithText("Label").assertIsDisplayed()
        composeRule.onNode(hasSetTextAction() and hasText("MeGo")).assertIsDisplayed()
    }
}

