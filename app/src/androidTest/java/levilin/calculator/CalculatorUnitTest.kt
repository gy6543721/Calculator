package levilin.calculator

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import levilin.calculator.ui.CalculatorView
import levilin.calculator.ui.theme.screenBackgroundColor
import levilin.calculator.utility.ConstantValue
import levilin.calculator.viewmodel.SharedViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorUnitTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        val sharedViewModel = composeTestRule.activity.viewModels<SharedViewModel>().value

        composeTestRule.setContent {
            CalculatorView(
                state = sharedViewModel.state,
                modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.screenBackgroundColor).padding(ConstantValue.CALCULATOR_PADDING),
                onAction = sharedViewModel::onAction
            )
        }
    }

    @Test
    fun check_number_button_function() {
        val resultPanelTag = composeTestRule.activity.getString(R.string.result_panel)
        val buttonOneTag = composeTestRule.activity.getString(R.string.button_one)
        val buttonTwoTag = composeTestRule.activity.getString(R.string.button_two)
        val buttonThreeTag = composeTestRule.activity.getString(R.string.button_three)
        val buttonFourTag = composeTestRule.activity.getString(R.string.button_four)
        val buttonFiveTag = composeTestRule.activity.getString(R.string.button_five)
        val buttonSixTag = composeTestRule.activity.getString(R.string.button_six)
        val buttonSevenTag = composeTestRule.activity.getString(R.string.button_seven)
        val buttonEightTag = composeTestRule.activity.getString(R.string.button_eight)
        val buttonNineTag = composeTestRule.activity.getString(R.string.button_nine)
        val buttonZeroTag = composeTestRule.activity.getString(R.string.button_zero)

        val resultValue = "1234567890"

        composeTestRule.onNodeWithTag(testTag = buttonOneTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonTwoTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonThreeTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonFourTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonFiveTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonSixTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonSevenTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonEightTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonNineTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonZeroTag).performClick()
        composeTestRule.onNodeWithTag(testTag = resultPanelTag).assert(hasText(text = resultValue, ignoreCase = true))
    }

    @Test
    fun check_all_clear_function() {
        val resultPanelTag = composeTestRule.activity.getString(R.string.result_panel)
        val buttonOneTag = composeTestRule.activity.getString(R.string.button_one)
        val buttonACTag = composeTestRule.activity.getString(R.string.button_ac)

        val resultValue = ""

        composeTestRule.onNodeWithTag(testTag = buttonOneTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonACTag).performClick()
        composeTestRule.onNodeWithTag(testTag = resultPanelTag).assert(hasText(text = resultValue, ignoreCase = true))
    }


    @Test
    fun check_sign_button_function() {
        val resultPanelTag = composeTestRule.activity.getString(R.string.result_panel)
        val buttonSignTag = composeTestRule.activity.getString(R.string.button_sign)
        val buttonOneTag = composeTestRule.activity.getString(R.string.button_one)

        val resultValue = "-1"

        composeTestRule.onNodeWithTag(testTag = buttonOneTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonSignTag).performClick()
        composeTestRule.onNodeWithTag(testTag = resultPanelTag).assert(hasText(text = resultValue, ignoreCase = true))
    }

    @Test
    fun check_decimal_function() {
        val resultPanelTag = composeTestRule.activity.getString(R.string.result_panel)
        val buttonDecimalTag = composeTestRule.activity.getString(R.string.button_decimal)
        val buttonOneTag = composeTestRule.activity.getString(R.string.button_one)

        val resultValue = "1."

        composeTestRule.onNodeWithTag(testTag = buttonOneTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonDecimalTag).performClick()
        composeTestRule.onNodeWithTag(testTag = resultPanelTag).assert(hasText(text = resultValue, ignoreCase = true))
    }


    @Test
    fun check_divide_zero_function() {
        val resultPanelTag = composeTestRule.activity.getString(R.string.result_panel)
        val buttonDivideTag = composeTestRule.activity.getString(R.string.button_divide)
        val buttonOneTag = composeTestRule.activity.getString(R.string.button_one)
        val buttonZeroTag = composeTestRule.activity.getString(R.string.button_zero)
        val buttonEqualTag = composeTestRule.activity.getString(R.string.button_equal)

        val resultValue = "1÷0"

        composeTestRule.onNodeWithTag(testTag = buttonOneTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonDivideTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonZeroTag).performClick()
        composeTestRule.onNodeWithTag(testTag = buttonEqualTag).performClick()
        composeTestRule.onNodeWithTag(testTag = resultPanelTag).assert(hasText(text = resultValue, ignoreCase = true))
    }

}