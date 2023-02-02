package levilin.calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import levilin.calculator.model.CalculatorAction
import levilin.calculator.model.CalculatorOperation
import levilin.calculator.model.CalculatorState
import levilin.calculator.ui.component.CalculatorButton
import levilin.calculator.ui.theme.*
import levilin.calculator.utility.ConstantValue
import levilin.calculator.ui.component.ResizableText

@Composable
fun CalculatorView(state: CalculatorState, modifier: Modifier = Modifier, onAction: (CalculatorAction) -> Unit) {

    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(ConstantValue.BUTTON_SPACING)
        ) {

            // Result Panel
            ResizableText(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(ConstantValue.TEXT_PADDING),
                textStyle = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = ConstantValue.TEXT_FONT_SIZE,
                    color = MaterialTheme.colors.screenTextColor
                ),
                maxLines = 1
            )

            // AC Button Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(ConstantValue.BUTTON_SPACING)
            ) {
                // AC Button
                CalculatorButton(
                    text = ConstantValue.ALL_CLEAR_BUTTON,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.otherButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Clear)
                    }
                )

                // Sign Button
                CalculatorButton(
                    text = ConstantValue.SIGN_BUTTON,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.otherButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Sign)
                    }
                )

                // Delete Button
                CalculatorButton(
                    text = ConstantValue.DELETE_BUTTON,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.otherButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Delete)
                    }
                )

                // Divide Button
                CalculatorButton(
                    text = ConstantValue.DIVIDE_BUTTON,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.operationButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    }
                )
            }

            // Number 7-9 Button Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(ConstantValue.BUTTON_SPACING)
            ) {
                // Number 7 Button
                CalculatorButton(
                    text = ConstantValue.SEVEN,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.numberButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(7))
                    }
                )

                // Number 8 Button
                CalculatorButton(
                    text = ConstantValue.EIGHT,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.numberButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(8))
                    }
                )

                // Number 9 Button
                CalculatorButton(
                    text = ConstantValue.NINE,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.numberButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(9))
                    }
                )

                // Multiply Button
                CalculatorButton(
                    text = ConstantValue.MULTIPLY_BUTTON,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.operationButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    }
                )
            }

            // Number 4-6 Button Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(ConstantValue.BUTTON_SPACING)
            ) {
                // Number 4 Button
                CalculatorButton(
                    text = ConstantValue.FOUR,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.numberButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(4))
                    }
                )

                // Number 5 Button
                CalculatorButton(
                    text = ConstantValue.FIVE,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.numberButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(5))
                    }
                )

                // Number 6 Button
                CalculatorButton(
                    text = ConstantValue.SIX,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.numberButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(6))
                    }
                )

                // Minus Button
                CalculatorButton(
                    text = ConstantValue.MINUS_BUTTON,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.operationButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Minus))
                    }
                )
            }

            // Number 1-3 Button Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(ConstantValue.BUTTON_SPACING)
            ) {
                // Number 1 Button
                CalculatorButton(
                    text = ConstantValue.ONE,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.numberButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(1))
                    }
                )

                // Number 2 Button
                CalculatorButton(
                    text = ConstantValue.TWO,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.numberButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(2))
                    }
                )

                // Number 3 Button
                CalculatorButton(
                    text = ConstantValue.THREE,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.numberButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(3))
                    }
                )

                // Add Button
                CalculatorButton(
                    text = ConstantValue.ADD_BUTTON,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.operationButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    }
                )
            }

            // Number 0 Button Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(ConstantValue.BUTTON_SPACING)
            ) {
                // Number 0 Button
                CalculatorButton(
                    text = ConstantValue.ZERO,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.numberButtonBackgroundColor)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Number(0))
                    }
                )

                // Decimal Button
                CalculatorButton(
                    text = ConstantValue.DECIMAL_BUTTON,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.operationButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Decimal)
                    }
                )

                // Equal Button
                CalculatorButton(
                    text = ConstantValue.EQUAL_BUTTON,
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.operationButtonBackgroundColor)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Calculate)
                    }
                )
            }
        }
    }
}