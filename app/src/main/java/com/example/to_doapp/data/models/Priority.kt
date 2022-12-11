package com.example.to_doapp.data.models

import androidx.compose.ui.graphics.Color
import com.example.to_doapp.ui.theme.HighPriorityColor
import com.example.to_doapp.ui.theme.LowPriorityColor
import com.example.to_doapp.ui.theme.MediumPriorityColor
import com.example.to_doapp.ui.theme.NonePriorityColor

// when we want to get the color
enum class Priority(val color: Color) {
    HIGH(color = HighPriorityColor),
    MEDIUM(color = MediumPriorityColor),
    LOW(color = LowPriorityColor),
    NONE(color = NonePriorityColor)
}