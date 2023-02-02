package levilin.calculator.ui.component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import levilin.calculator.ui.theme.screenTextColor
import levilin.calculator.utility.ConstantValue
import levilin.calculator.viewmodel.SharedViewModel

@Composable
fun ResizableText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colors.screenTextColor,
    textAlign: TextAlign = TextAlign.Center,
    textStyle: TextStyle,
    targetTextSize: TextUnit = textStyle.fontSize,
    maxLines: Int = 1
) {
    var textSize by remember { mutableStateOf(targetTextSize) }

    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
        fontSize = textSize,
        fontFamily = textStyle.fontFamily,
        fontStyle = textStyle.fontStyle,
        fontWeight = textStyle.fontWeight,
        lineHeight = textStyle.lineHeight,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        onTextLayout = { textLayoutResult ->
            // Resize textSize
            val maxCurrentLineIndex: Int = textLayoutResult.lineCount - 1
            if (textLayoutResult.isLineEllipsized(maxCurrentLineIndex)) {
                textSize = textSize.times(ConstantValue.TEXT_SCALE_REDUCTION_INTERVAL)
            }

            // Resize textSize to default if content is cleared
            if (text.isBlank() || text == "") {
                textSize = textStyle.fontSize
            }
        }
    )
}
