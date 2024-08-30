package com.nuvemconnect.app.nuvemconnect.model.error

import androidx.compose.runtime.Immutable

@Immutable
sealed class NameErrorType(name: String) {
    object None : NameErrorType("")
    object Empty : NameErrorType("O campo de nome não pode estar vazio.")
}