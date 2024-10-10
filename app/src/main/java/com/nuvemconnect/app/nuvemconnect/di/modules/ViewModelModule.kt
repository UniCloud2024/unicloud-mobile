package com.nuvemconnect.app.nuvemconnect.di.modules

import com.nuvemconnect.app.nuvemconnect.ui.screens.home.HomeViewModel
import com.nuvemconnect.app.nuvemconnect.ui.screens.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule =
    module {
        viewModel { LoginViewModel() }
        viewModel { HomeViewModel() }
    }