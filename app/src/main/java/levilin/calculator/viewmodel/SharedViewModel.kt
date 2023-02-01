package levilin.calculator.viewmodel

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import levilin.calculator.model.CalculatorAction
import levilin.calculator.model.CalculatorOperation
import levilin.calculator.model.CalculatorState
import levilin.calculator.utility.ConstantValue

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
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(number1 = state.number1 + ConstantValue.DECIMAL_BUTTON)
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(number2 = state.number2 + ConstantValue.DECIMAL_BUTTON)
        }
    }

    private fun inputSign() {
        if (state.operation == null) {
            state = when(state.number1) {
                "" -> state.copy(number1 = ConstantValue.MINUS_BUTTON)
                "-" -> state.copy(number1 = "")
                else -> {
                    val number1ToDouble = state.number1.toDouble()
                    val changedValue = changeSign(number1ToDouble)
                    state.copy(number1 = changedValue)
                }
            }
        } else {
            state = when(state.number2) {
                "" -> state.copy(number2 = ConstantValue.MINUS_BUTTON)
                "-" -> state.copy(number2 = "")
                else -> {
                    val number2ToDouble = state.number2.toDouble()
                    val changedValue = changeSign(number2ToDouble)
                    state.copy(number2 = changedValue)
                }
            }
        }
    }

    private fun inputOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun performCalculate() {
        val number1ToDouble = state.number1.toDoubleOrNull()
        Log.d("TAG", "number1ToDouble:" + number1ToDouble.toString())

        val number2ToDouble = state.number2.toDoubleOrNull()
        Log.d("TAG", "number2ToDouble:" + number2ToDouble.toString())

        if (number1ToDouble != null && number2ToDouble != null) {
            val result = when(state.operation) {
                is CalculatorOperation.Add -> number1ToDouble + number2ToDouble
                is CalculatorOperation.Minus -> number1ToDouble - number2ToDouble
                is CalculatorOperation.Multiply -> number1ToDouble * number2ToDouble
                is CalculatorOperation.Divide -> number1ToDouble / number2ToDouble
                null -> return
            }

            // Update state
            state = state.copy(
                number1 = formattedResult(result),
                number2 = "",
                operation = null
            )
        }
    }

    private fun performDeletion() {
        when {
            state.number1.isNotBlank() -> state = state.copy(number1 = state.number1.dropLast(1))
            state.number2.isNotBlank() -> state = state.copy(number2 = state.number2.dropLast(1))
            state.operation != null -> state = state.copy(operation = null)
        }
    }

    private fun changeSign(value: Double): String {
        return if (value % 1 != 0.0) {
            (value * -1).toString()
        } else {
            (value * -1).toInt().toString()
        }
    }

    private fun formattedResult(value: Double): String {
        return if (value % 1 != 0.0) {
            "%.3f".format(value)
        } else {
            value.toInt().toString()
        }
    }
}