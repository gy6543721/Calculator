package levilin.calculator.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.sp
import levilin.calculator.ui.theme.screenTextColor
import levilin.calculator.utility.ConstantValue

@Composable
fun CalculatorButton(text: String, modifier: Modifier, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .then(modifier),
    ) {
        Text(
            text = text,
            fontSize = ConstantValue.BUTTON_FONT_SIZE,
            color = MaterialTheme.colors.screenTextColor
        )
    }
}