package com.example.quotesapp.data.models

data class ResponseQuotes(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<QuotesResult>,
    val totalCount: Int,
    val totalPages: Int
)