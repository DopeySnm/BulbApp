package com.example.bulbapp.domain

import com.example.bulbapp.data.repository.BulbRepository
import com.example.bulbapp.data.repository.model.BulbBrightnessLevel
import javax.inject.Inject

interface GetBrightnessLevelUseCase {
    suspend operator fun invoke(): Result<BulbBrightnessLevel?>
}

class GetBrightnessLevelUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
) : GetBrightnessLevelUseCase{
    override suspend fun invoke(): Result<BulbBrightnessLevel?> {
        return repository.getBrightnessLevelInfo()
    }
}