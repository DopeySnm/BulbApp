package com.example.bulbapp.domain

import com.example.bulbapp.data.repository.BulbRepository
import javax.inject.Inject

interface SetStateBulbUseCase {
    suspend operator fun invoke(state: Boolean): Result<Boolean?>
}

class SetStateBulbUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
) : SetStateBulbUseCase {
    override suspend fun invoke(state: Boolean): Result<Boolean?> {
        return repository.turnOnOff(state)
    }
}