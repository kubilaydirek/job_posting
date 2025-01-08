package com.example.jobposting.ui.scene.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import com.example.jobposting.data.validator.EmailValidator
import com.example.jobposting.data.validator.PasswordValidator
import com.example.jobposting.data.validator.TextFieldValidator

class RegisterViewState {
    val firstName: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))
    val lastName: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))
    val email: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))
    val password: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))

    //validation
    val emailIsValid: MutableState<Boolean> = mutableStateOf(false)
    val firstNameIsValid: MutableState<Boolean> = mutableStateOf(false)
    val lastNameIsValid: MutableState<Boolean> = mutableStateOf(false)
    val passwordIsValid: MutableState<Boolean> = mutableStateOf(false)

    fun isValid(): Boolean {
        firstNameIsValid.value = firstName.value.let { TextFieldValidator().validate(firstName.value.text) }
        lastNameIsValid.value = lastName.value.let { TextFieldValidator().validate(lastName.value.text) }
        emailIsValid.value = email.value.let { EmailValidator().validate(email.value.text) }
        passwordIsValid.value = password.value.let { PasswordValidator().validate(password.value.text) }

        return (!firstNameIsValid.value && !lastNameIsValid.value && !emailIsValid.value && !passwordIsValid.value)
    }

}

@Composable
fun rememberRegisterViewState(): RegisterViewState = remember {
    RegisterViewState()
}