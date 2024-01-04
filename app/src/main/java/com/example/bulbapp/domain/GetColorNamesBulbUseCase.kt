package com.example.bulbapp.domain

import com.example.bulbapp.data.repository.BulbRepository
import javax.inject.Inject

interface GetColorNamesBulbUseCase {
    suspend operator fun invoke(): Result<List<String>?>
}

class GetColorNamesBulbUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
) : GetColorNamesBulbUseCase {
    override suspend fun invoke(): Result<List<String>?> {
        return repository.getColors()
    }
}