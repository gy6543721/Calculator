package levilin.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import levilin.calculator.ui.CalculatorView
import levilin.calculator.ui.theme.*
import levilin.calculator.utility.ConstantValue
import levilin.calculator.viewmodel.SharedViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {

                val viewModel = viewModel<SharedViewModel>()
                val state = viewModel.state

                CalculatorView(
                    state = state,
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.screenBackgroundColor).padding(ConstantValue.CALCULATOR_PADDING).statusBarsPadding().navigationBarsPadding(),
                    onAction = viewModel::onAction
                )

            }
        }
    }
}