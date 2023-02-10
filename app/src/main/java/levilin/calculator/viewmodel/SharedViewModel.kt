package levilin.calculator.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import levilin.calculator.model.CalculatorAction
import levilin.calculator.model.CalculatorOperation
import levilin.calculator.model.CalculatorState
import levilin.calculator.utility.ConstantValue
import java.math.BigDecimal

class SharedViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when(action) {
            is CalculatorAction.Number -> inputNumber(action.number)
            is CalculatorAction.Decimal -> inputDecimal()
            is CalculatorAction.Sign -> inputSign()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> inputOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculate()
            is CalculatorAction.Delete -> performDeletion()
        }
    }

    private fun inputNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= ConstantValue.MAX_INPUT_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= ConstantValue.MAX_INPUT_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    private fun inputDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.contains("[0-9]".toRegex())) {
            state = state.copy(number1 = state.number1 + ConstantValue.DECIMAL_BUTTON)
            return
        }
        if (!state.number2.contains(".") && state.number2.contains("[0-9]".toRegex())) {
            state = state.copy(number2 = state.number2 + ConstantValue.DECIMAL_BUTTON)
        }
    }

    private fun inputSign() {
        if (state.operation == null) {
            state = when(state.number1) {
                "" -> state.copy(number1 = ConstantValue.MINUS_BUTTON)
                "-" -> state.copy(number1 = "")
                else -> {
                    val number1ToBigDecimal = BigDecimal(state.number1)
                    val number1ChangedValue = changeSign(number1ToBigDecimal)
                    state.copy(number1 = number1ChangedValue)
                }
            }
        } else {
            state = when(state.number2) {
                "" -> state.copy(number2 = ConstantValue.MINUS_BUTTON)
                "-" -> state.copy(number2 = "")
                else -> {
                    val number2ToBigDecimal = BigDecimal(state.number2)
                    val number2ChangedValue = changeSign(number2ToBigDecimal)
                    state.copy(number2 = number2ChangedValue)
                }
            }
        }
    }

    private fun inputOperation(operation: CalculatorOperation) {
        if (state.number1.contains("[0-9]".toRegex())) {
            state = state.copy(operation = operation)
        }
    }

    private fun performCalculate() {
        if (state.number1.contains("[0-9]".toRegex()) && state.number2.contains("[0-9]".toRegex())) {
            val number1ToBigDecimal = BigDecimal(state.number1)
            val number2ToBigDecimal = BigDecimal(state.number2)

            val result = when(state.operation) {
                is CalculatorOperation.Add -> number1ToBigDecimal.add(number2ToBigDecimal)
                is CalculatorOperation.Minus -> number1ToBigDecimal.subtract(number2ToBigDecimal)
                is CalculatorOperation.Multiply -> number1ToBigDecimal.multiply(number2ToBigDecimal)
                is CalculatorOperation.Divide -> {
                    if (number2ToBigDecimal != BigDecimal(0)) {
                        number1ToBigDecimal.divide(number2ToBigDecimal, ConstantValue.DECIMAL_LENGTH, BigDecimal.ROUND_HALF_UP)
                    } else {
                        return
                    }
                }
                null -> return
            }

            // Update state
            state = state.copy(
                number1 = result.stripTrailingZeros().toPlainString(),
                number2 = "",
                operation = null
            )
        }
    }

    private fun performDeletion() {
        when {
            // Delete number2 first, then operation symbol, then number1
            state.number2.isNotEmpty() -> state = state.copy(number2 = state.number2.dropLast(1))
            state.operation != null -> state = state.copy(operation = null)
            state.number1.isNotEmpty() -> state = state.copy(number1 = state.number1.dropLast(1))
        }
    }

    private fun changeSign(value: BigDecimal): String {
        val minusOne = BigDecimal(-1)
        return (value.multiply(minusOne)).stripTrailingZeros().toPlainString()
    }
}