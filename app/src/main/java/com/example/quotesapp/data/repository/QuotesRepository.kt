package com.example.quotesapp.data.repository

import com.example.quotesapp.data.api.ApiService
import com.example.quotesapp.data.models.QuotesResult
import com.example.quotesapp.data.models.ResponseQuotes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class QuotesRepository @Inject constructor(private val apiService: ApiService)
{
    fun getQuotesRandomRepo() : Flow<QuotesResult> = flow {
        val response = apiService.getRandomQuotes()
        emit(response)
    }.flowOn(Dispatchers.IO)

    fun getQuotesRepo(): Flow<ResponseQuotes> = flow {
        val response = apiService.getListOfQuotes()
        emit(response)
    }.flowOn(Dispatchers.IO)

}