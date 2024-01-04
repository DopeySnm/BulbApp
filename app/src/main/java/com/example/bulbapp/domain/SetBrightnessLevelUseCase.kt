package com.example.bulbapp.domain

import com.example.bulbapp.data.repository.BulbRepository
import javax.inject.Inject

interface SetBrightnessLevelUseCase {
     suspend operator fun invoke(level: Int): Result<Boolean?>
}

class SetBrightnessLevelUseCaseImpl @Inject constructor(
    val repository: BulbRepository
): SetBrightnessLevelUseCase {
    override suspend fun invoke(level: Int): Result<Boolean?> {
        return repository.setBrightnessLevel(level)
    }
}