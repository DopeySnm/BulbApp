package com.example.bulbapp.domain

import com.example.bulbapp.data.repository.BulbRepository
import com.example.bulbapp.data.repository.model.Color
import javax.inject.Inject

interface GetCurrentColorUseCase {
    suspend operator fun invoke() : Result<Color?>
}

class GetCurrentColorUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
) : GetCurrentColorUseCase {
    override suspend fun invoke(): Result<Color?> {
       return repository.getCurrentColor()
    }
}