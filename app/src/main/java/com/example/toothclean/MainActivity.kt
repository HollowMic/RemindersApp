package com.example.toothclean

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.toothclean.ui.theme.ToothCleanTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToothCleanTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage()
                }
            }
        }
    }
}

@Composable
fun MainPage(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {

//        fun toggleButtons(buttonState: ButtonState) {
//            if (buttonState == ButtonState.DayTime) {
//
//            }
//        }

        var date by remember {mutableStateOf(LocalDate.now())}

        val storageBox by remember { mutableStateOf(StorageBox()) }

        var reminderObject by remember { mutableStateOf(storageBox.getTodaysData()) }

        var morningTeethDone by remember { mutableStateOf(reminderObject.getValue("morning"))}
        var nightTeethDone by remember { mutableStateOf(false)}

        Column {
            Box(
                modifier
                    .weight(1F)
                    .fillMaxSize()
            ) {
                /**
                 * Top (Date)
                 */

                val dayFormatter = DateTimeFormatter.ofPattern("EEEE',\n'dd'th of' MMM")
                val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

                Column(
                    modifier = Modifier.fillMaxSize().padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        text = date.format(dayFormatter),
                        fontSize = 9.em,
                        modifier = Modifier.padding(10.dp),
                        overflow = TextOverflow.Visible,
                        lineHeight = 50.sp,
                        textAlign = TextAlign.Center
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        IconButton(onClick = {
                            date = date.minusDays(1)
                        }) {
                            Icon(
                                imageVector = Icons.Rounded.KeyboardArrowLeft,
                                contentDescription = "",
                            )
                        }
                        Text(text = date.format(formatter), fontSize = 7.em)
                        IconButton(onClick = {
                            date = date.plusDays(1)
                        }) {
                            Icon(
                                imageVector = Icons.Rounded.KeyboardArrowRight,
                                contentDescription = "",
                            )
                        }
                    }
                }


            }
            Box(
                modifier
                    .weight(1F)
                    .fillMaxSize()
            ) {
                /**
                 * Bottom (Buttons)
                 */

                fun toggleMorningTeethDone() {
                    reminderObject.toggleValue("morning")
                    morningTeethDone = !morningTeethDone
                    println(reminderObject.getValue("morning"))
                }
                fun toggleNightTeethDone() {
                    nightTeethDone = !nightTeethDone
                }

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    ReminderToggle(
                        ToggleState(morningTeethDone) { toggleMorningTeethDone() },
                        titleText = "Morning"
                    )
                    ReminderToggle(
                        ToggleState(nightTeethDone) { toggleNightTeethDone() },
                        titleText = "Night"
                    )
                }
            }
        }
    }
}

