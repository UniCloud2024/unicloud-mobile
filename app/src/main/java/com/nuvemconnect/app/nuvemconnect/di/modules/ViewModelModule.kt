package com.nuvemconnect.app.nuvemconnect.di.modules

import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.ResetPasswordViewModel
import com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens.VerificationCodeViewModel
import com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword.ForgotPasswordViewModel
import com.nuvemconnect.app.nuvemconnect.ui.screens.home.HomeViewModel
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginViewModel
import com.nuvemconnect.app.nuvemconnect.ui.screens.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule =
    module {
        viewModel { LoginViewModel() }
        viewModel { HomeViewModel() }
        viewModel { ForgotPasswordViewModel() }
        viewModel { VerificationCodeViewModel() }
        viewModel { ResetPasswordViewModel() }
        viewModel { RegisterViewModel() }
    }
