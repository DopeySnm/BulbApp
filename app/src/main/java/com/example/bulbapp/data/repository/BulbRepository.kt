package com.example.bulbapp.data.repository

import retrofit2.HttpException
import com.example.bulbapp.data.api.BulbService
import com.example.bulbapp.data.repository.model.BulbBrightnessLevel
import com.example.bulbapp.data.repository.model.Color
import javax.inject.Inject


interface BulbRepository {

    suspend fun turnOnOff(turnOn: Boolean): Result<Boolean?>

    suspend fun getState(): Result<Boolean?>

    suspend fun getCurrentColor(): Result<Color?>

    suspend fun getColors(): Result<List<String>?>

    suspend fun getBrightnessLevelInfo(): Result<BulbBrightnessLevel?>

    suspend fun getCurrentBrightnessLevel(): Result<Int?>

    suspend fun setBrightnessLevel(level: Int): Result<Boolean?>

    suspend fun setColor(color: String): Result<Boolean?>
}

class BulbRepositoryImpl @Inject constructor(
    private val service: BulbService
) : BulbRepository {

    override suspend fun turnOnOff(state: Boolean): Result<Boolean?> {
        kotlin.runCatching {
            if (state){
                service.turnOn()
            }else {
                service.turnOff()
            }
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getState(): Result<Boolean?> {
        kotlin.runCatching {
            service.getState()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getCurrentColor(): Result<Color?> {
        kotlin.runCatching {
            service.getCurrentColor()
        }.fold(
            onSuccess = {
               return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getColors(): Result<List<String>?> {
        kotlin.runCatching {
            service.getColors()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getBrightnessLevelInfo(): Result<BulbBrightnessLevel?> {
        kotlin.runCatching {
            service.getBrightnessLevelInfo()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getCurrentBrightnessLevel(): Result<Int?> {
        kotlin.runCatching {
            service.getCurrentBrightnessLevel()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun setBrightnessLevel(level: Int): Result<Boolean?> {
        kotlin.runCatching {
            service.setBrightnessLevel(level)
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun setColor(color: String): Result<Boolean?> {
        kotlin.runCatching {
            service.setColor(color)
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

}