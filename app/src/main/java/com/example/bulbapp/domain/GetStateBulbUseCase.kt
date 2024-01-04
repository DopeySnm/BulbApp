package com.example.bulbapp.domain

import com.example.bulbapp.data.repository.BulbRepository
import javax.inject.Inject

interface GetStateBulbUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}

class GetStateBulbUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
): GetStateBulbUseCase {
    override suspend fun invoke(): Result<Boolean?> {
        return repository.getState()
    }

}