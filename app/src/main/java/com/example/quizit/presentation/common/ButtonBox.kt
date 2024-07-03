package com.example.quizit.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.example.quizit.R
import com.example.quizit.presentation.util.Dimens

@Preview
@Composable
fun PrevBB(){
ButtonBox(
    text = "Generate Quiz"
){
    
}
}

@Composable
fun ButtonBox(
    modifier: Modifier=Modifier,
    text: String,
    padding: Dp=Dimens.SmallPadding,
    borderColor: Color= colorResource(id = R.color.uppertext),

    fraction: Float=1f,
    fontSize: TextUnit=Dimens.MediumTextSize,
textColor: Color=colorResource(id = R.color.black),
    containerColor: Color=colorResource(id = R.color.uppertext),
    onClick:()->Unit
) {
Box(modifier = Modifier
    .padding(padding)
    .clickable { onClick() }
    .fillMaxWidth(fraction)
    .height(Dimens.MediumBoxHeight)
    .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
    .background(containerColor),
   contentAlignment = Alignment.Center
){
    Text(text = text,
         fontSize = fontSize,
        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
        color = textColor
        )
}

}