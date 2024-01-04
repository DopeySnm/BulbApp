package com.example.bulbapp.di.modules

import com.example.bulbapp.data.repository.BulbRepository
import com.example.bulbapp.data.repository.BulbRepositoryImpl
import com.example.bulbapp.domain.*
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {

    @Binds
    fun bindSetColorBulbUseCase(useCase: SetColorBulbUseCaseImpl) : SetColorBulbUseCase

    @Binds
    fun bindSetBrightnessLevelUseCase(useCase: SetBrightnessLevelUseCaseImpl) : SetBrightnessLevelUseCase

    @Binds
    fun bindSetStateBulbUseCase(useCase: SetStateBulbUseCaseImpl) : SetStateBulbUseCase

    @Binds
    fun bindGetCurrentColorUseCase(useCase: GetCurrentColorUseCaseImpl) : GetCurrentColorUseCase

    @Binds
    fun bindGetCurrentBrightnessLevelUseCase(useCase: GetCurrentBrightnessLevelUseCaseImpl) : GetCurrentBrightnessLevelUseCase

    @Binds
    fun bindGetColorNamesBulbUseCase(useCase: GetColorNamesBulbUseCaseImpl) : GetColorNamesBulbUseCase

    @Binds
    fun bindGetStateBulbUseCase(useCase: GetStateBulbUseCaseImpl) : GetStateBulbUseCase

    @Binds
    fun bindGetBrightnessLevelUseCase(useCase: GetBrightnessLevelUseCaseImpl) :  GetBrightnessLevelUseCase

    @Binds
    fun bindBulbRepository(repository: BulbRepositoryImpl) : BulbRepository
}