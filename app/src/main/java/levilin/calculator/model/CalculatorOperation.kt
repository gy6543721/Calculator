package levilin.calculator.model

import levilin.calculator.utility.ConstantValue

sealed class CalculatorOperation(val symbol: String) {
    object Add: CalculatorOperation(symbol = ConstantValue.ADD_BUTTON)
    object Minus: CalculatorOperation(symbol = ConstantValue.MINUS_BUTTON)
    object Multiply: CalculatorOperation(symbol = ConstantValue.MULTIPLY_BUTTON)
    object Divide: CalculatorOperation(symbol = ConstantValue.DIVIDE_BUTTON)
}
