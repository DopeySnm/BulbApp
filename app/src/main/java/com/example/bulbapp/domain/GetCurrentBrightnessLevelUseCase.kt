package com.example.bulbapp.domain

import com.example.bulbapp.data.repository.BulbRepository
import javax.inject.Inject

interface GetCurrentBrightnessLevelUseCase {
    suspend operator fun invoke(): Result<Int?>
}

class GetCurrentBrightnessLevelUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
) : GetCurrentBrightnessLevelUseCase {
    override suspend fun invoke(): Result<Int?> {
        return repository.getCurrentBrightnessLevel()
    }
}