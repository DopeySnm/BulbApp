package com.example.bulbapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bulbapp.di.viewModel.ViewModelFactory
import com.example.bulbapp.di.viewModel.ViewModelKey
import com.example.bulbapp.presenter.bulb.BulbViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(BulbViewModel::class)
    abstract fun bindBulbViewModel(bulbViewModel: BulbViewModel) : ViewModel
}