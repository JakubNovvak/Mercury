package com.example.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import com.example.presentation.R
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.getSelectedText
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.login.components.LoginTextField

@Composable
fun LoginScreen(onLogin: () -> Unit): Unit {
    var textFieldLoginValue by remember { mutableStateOf("jakubnovvak") }
    var textFieldPasswordValue by remember { mutableStateOf("password123!") }

    Column(
        modifier = Modifier.fillMaxSize().padding(bottom = 80.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = (R.drawable.mercury_logo)),
            contentDescription = "Logo of the app",
            Modifier.size(100.dp, 100.dp)
        )

        Text(
            text = "Welcome to Mercury",
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 10.dp),
            fontWeight = FontWeight.W400
        )

        Text(
            text = "Log in to your account",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 10.dp, top = 30.dp),
            fontWeight = FontWeight.W300
        )

        LoginTextField(
            label = "Username",
            value = textFieldLoginValue,
            onValueChange = {newText -> textFieldLoginValue = newText}
        )

        LoginTextField(
            label = "Password",
            isPasswordField = true,
            value = textFieldPasswordValue,
            onValueChange = {newText -> textFieldPasswordValue = newText}
        )

        Button(
            onClick = onLogin,
            modifier = Modifier.padding(top = 40.dp).width(150.dp),
            colors = ButtonDefaults.buttonColors(Color(0xff279fdc))
        ) {
            Text(
                "Log in",
                color = Color.White
            )
        }
    }
}