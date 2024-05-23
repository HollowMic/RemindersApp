package com.example.toothclean

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ReminderToggle(
    toggleState: ToggleState,
    titleText:String = "Toggle"
) {
    Row (
        modifier = Modifier.padding(10.dp)
    ) {
        Button(
            modifier = Modifier
                .height(50.dp)
                .weight(weightReturn(toggleState.state, false))
                .padding(0.dp, 0.dp, 10.dp, 0.dp),
            onClick = {toggleState.toggle()},
            enabled = !toggleState.state,
            colors = ButtonDefaults.buttonColors(disabledContainerColor = Color(80, 255, 10, 100))
        ) {
            Text(text = titleText)
        }
        Button(
            modifier = Modifier
                .height(50.dp)
                .weight(weightReturn(toggleState.state, true)),
            onClick = {toggleState.toggle()},
            enabled = toggleState.state,
        ) {
            Text(text = "undo")
        }
    }
}


fun weightReturn(teethDone:Boolean, isUndo:Boolean): Float {
    return if (teethDone) {
        if (isUndo) {
            8F
        } else {
            4F
        }
    } else {
        if (isUndo) {
            3F
        } else {
            8F
        }
    }
}