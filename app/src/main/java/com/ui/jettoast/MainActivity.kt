package com.ui.jettoast

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ui.jettoast.ui.theme.JettoastTheme
import com.ui.toast.Toast
import com.ui.toast.utils.ToastDelay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            JettoastTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    ListOfToasts()
                }
            }
        }
    }
}

@Composable
fun ListOfToasts() {
    Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
        DefaultToast()
        ColorToast()
        FullWidthRoundedToast()
        FullWidthRectangleToast()
        LeadingIconToast()
        TrailingIconToast()
        LeadingTrailingIconToast()
        FixedUntilClickIconToast()
    }
}

@Composable
fun DefaultToast() {
    var showToast by remember {
        mutableStateOf(false)
    }

    Column(Modifier.height(80.dp)) {

        Text("Default Toast", Modifier.fillMaxWidth().clickable {
                showToast = true
        }, textAlign = TextAlign.Center)
        Toast(
            message = "Simple Toast",
            showToast = showToast,
            afterToastShown = { showToast = it },
        )
    }
}

@Composable
fun ColorToast() {
    var showToast by remember {
        mutableStateOf(false)
    }

    Column(Modifier.height(80.dp)) {

        Text("Colorful Toast", Modifier.fillMaxWidth().clickable {
            showToast = true
        }, textAlign = TextAlign.Center)
        Toast(
            message = "Colorful Toast",
            showToast = showToast,
            afterToastShown = { showToast = it },
            background = Color.Red
        )
    }
}

@Composable
fun FullWidthRoundedToast() {
    var showToast by remember {
        mutableStateOf(false)
    }

    Column(Modifier.height(80.dp)) {

        Text("Full Width Rounded Toast", Modifier.fillMaxWidth().clickable {
               showToast = true
        }, textAlign = TextAlign.Center)
        Toast(
            message = "Full Width Rounded Toast",
            showToast = showToast,
            afterToastShown = { showToast = it },
            background = Color.Red,
            fillMaxWidth = true,
        )
    }
}

@Composable
fun LeadingIconToast() {
    var showToast by remember {
        mutableStateOf(false)
    }

    Column(Modifier.height(80.dp)) {

        Text("Leading Icon Toast", Modifier.fillMaxWidth().clickable {
            showToast = true
        }, textAlign = TextAlign.Center)
        Toast(
            message = "Leading Icon Toast",
            showToast = showToast,
            afterToastShown = { showToast = it },
            background = Color.Black,
            leadingIconSpace = 4.dp,
            leadingContent = {
                Image(imageVector = Icons.Default.Person, contentDescription = "Person",
                colorFilter = ColorFilter.tint(Color.White))
            }
        )
    }
}

@Composable
fun FixedUntilClickIconToast() {
    var showToast by remember {
        mutableStateOf(false)
    }

    Column(Modifier.height(80.dp)) {

        Text("Fixed Until Click Toast", Modifier.fillMaxWidth().clickable {
            showToast = true
        }, textAlign = TextAlign.Center)
        Toast(
            message = "Fixed Until Click Toast",
            showToast = showToast,
            afterToastShown = { showToast = it },
            background = Color.Black,
            trailingIconSpace = 4.dp,
            disableAutoHide = true,
            fillMaxWidth = true,
            shape = RectangleShape,
            trailingContent = {
               Text(text = "OK", modifier = Modifier.clickable { showToast = false },
               color = Color.White)
            }
        )
    }
}

@Composable
fun LeadingTrailingIconToast() {
    var showToast by remember {
        mutableStateOf(false)
    }

    Column(Modifier.height(80.dp)) {

        Text("Leading & Trailing Icon Toast", Modifier.fillMaxWidth().clickable {
            showToast = true
        }, textAlign = TextAlign.Center)
        Toast(
            message = "Leading & Trailing Icon Toast",
            showToast = showToast,
            afterToastShown = { showToast = it },
            background = Color.Black,
            leadingIconSpace = 4.dp,
            leadingContent = {
                Image(imageVector = Icons.Default.Person, contentDescription = "Person",
                    colorFilter = ColorFilter.tint(Color.White))
            },
            trailingIconSpace = 4.dp,
            trailingContent = {
                Image(imageVector = Icons.Default.AccountCircle, contentDescription = "Person",
                    colorFilter = ColorFilter.tint(Color.White))
            }
        )
    }
}

@Composable
fun TrailingIconToast() {
    var showToast by remember {
        mutableStateOf(false)
    }

    Column(Modifier.height(80.dp)) {

        Text("Trailing Icon Toast", Modifier.fillMaxWidth().clickable {
               showToast = true
        }, textAlign = TextAlign.Center)
        Toast(
            message = "Trailing Icon Toast",
            showToast = showToast,
            afterToastShown = { showToast = it },
            textColor = Color.Black,
            background = Color.Yellow,
            trailingIconSpace = 4.dp,
            trailingContent = {
                Image(imageVector = Icons.Default.Person, contentDescription = "Person",
                    colorFilter = ColorFilter.tint(Color.Black))
            }
        )
    }
}

@Composable
fun FullWidthRectangleToast() {
    var showToast by remember {
        mutableStateOf(false)
    }

    Column(Modifier.height(80.dp)) {

        Text("Full Width Rectangle Toast", Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Toast(
            message = "Full Width Rectangle Toast",
            showToast = showToast,
            afterToastShown = { showToast = it },
            background = Color.Red,
            fillMaxWidth = true,
            shape = RectangleShape
        )
    }
}

@Composable
fun ShowSimpleToast() {
    var showToast by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { showToast = true} ) {
            Text(text = "Click Here")
        }

        Toast(
            message = "Welcome welcome!",
            showToast = showToast,
            afterToastShown = { showToast = it },
            toastDelay = ToastDelay.ShortDelay,
            shape = CircleShape,
            fillMaxWidth = false,
            background = Color.Red,
            disableAutoHide = false,
            leadingContent = {
                Text(text = "OK", modifier = Modifier.clickable { showToast = false })
            },
            leadingIconSpace = 8.dp,
            trailingIconSpace = 8.dp,
            trailingContent = {
                Text(text = "OK", modifier = Modifier.clickable { showToast = false })
            }
        )
    }
}