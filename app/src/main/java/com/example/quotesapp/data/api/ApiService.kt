package com.example.quotesapp.data.api

import com.example.quotesapp.data.api.Constants.Companion.List_Of_quotes
import com.example.quotesapp.data.api.Constants.Companion.random_quotes
import com.example.quotesapp.data.models.QuotesResult
import com.example.quotesapp.data.models.ResponseQuotes
import okhttp3.Response
import retrofit2.http.GET

interface ApiService {
    @GET(List_Of_quotes)
    suspend fun getListOfQuotes(): ResponseQuotes

    @GET(random_quotes)
    suspend fun getRandomQuotes(): QuotesResult
}