package com.nuvemconnect.app.nuvemconnect.model.error

import androidx.compose.runtime.Immutable


@Immutable
sealed class PasswordErrorType(val message: String) {
    object None: PasswordErrorType("")
    object Empty: PasswordErrorType("Campo obrigatório")
    object rulePassword: PasswordErrorType("A senha precisa conter no mínimo 8 caracteres contendo ao menos 1 maiúsculo, 1 minúsculo, 1 número e um caractere especial. Mas, não pode conter espaços ou o símbolo @")
    object IncorrectPassword: PasswordErrorType("Senha incorreta")
    object minimumPassword: PasswordErrorType("A senha deve contar no mínimo 8 digitos")

}