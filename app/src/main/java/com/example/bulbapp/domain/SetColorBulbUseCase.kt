package com.example.bulbapp.domain

import com.example.bulbapp.data.repository.BulbRepository
import com.example.bulbapp.data.repository.model.Color
import javax.inject.Inject

interface SetColorBulbUseCase {
    suspend operator fun invoke(colon: String)
}

class SetColorBulbUseCaseImpl @Inject constructor(
    val repository: BulbRepository
): SetColorBulbUseCase {
    override suspend fun invoke(colon: String) {
        repository.setColor(colon)
    }
}