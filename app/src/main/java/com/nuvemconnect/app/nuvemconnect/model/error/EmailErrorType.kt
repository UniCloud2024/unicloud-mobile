package com.nuvemconnect.app.nuvemconnect.model.error

import android.util.Patterns
import androidx.compose.runtime.Immutable

@Immutable
sealed class EmailErrorType(val message: String) {
    object None : EmailErrorType("")
    object Empty : EmailErrorType("O campo de e-mail não pode estar vazio.")
    object InvalidFormat : EmailErrorType("Formato de e-mail inválido.")
}

