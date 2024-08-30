package com.nuvemconnect.app.nuvemconnect.util.validators

fun validatePassword(password: String): String? {
    if (password.length < 8) {
        return "A senha precisa ter no mínimo 8 caracteres."
    }
    if (!password.any { it.isUpperCase() }) {
        return "A senha precisa ter ao menos 1 letra maiúscula."
    }
    if (!password.any { it.isLowerCase() }) {
        return "A senha precisa ter ao menos 1 letra minúscula."
    }
    if (!password.any { it.isDigit() }) {
        return "A senha precisa ter ao menos 1 número."
    }
    if (!password.any { it.isSpecialCharacter() }) {
        return "A senha precisa ter ao menos 1 caractere especial."
    }
    if (password.contains(' ')) {
        return "A senha não pode conter espaços."
    }
    if (password.contains('@')) {
        return "A senha não pode conter o símbolo '@'."
    }
    return null
}

fun Char.isSpecialCharacter(): Boolean {
    return "!#$%&()*+,-./:;<=>?[]^_`{|}~".contains(this)
}