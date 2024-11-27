package com.example.quotesapp.data.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.data.models.QuotesResult
import com.example.quotesapp.data.repository.QuotesRepository
import com.example.quotesapp.data.utils.CommonFunction.isNetworkAvailable
import com.example.quotesapp.include.QuotesState
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class QuotesViewModel @Inject constructor(
    private val repository: QuotesRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val _responseRandomQuotes: MutableStateFlow<QuotesState<QuotesResult>> =
        MutableStateFlow(QuotesState.Loading)

    val responseRandom: StateFlow<QuotesState<QuotesResult>> = _responseRandomQuotes

    init {
        fetchRandomQuotes()
    }

    fun fetchRandomQuotes() {

        viewModelScope.launch {

            if (isNetworkAvailable(context)) {
                try {

                } catch (e: Exception) {
                    val errorMesssage = "An error occured, Please try again"
                    _responseRandomQuotes.emit(QuotesState.Error(errorMesssage))
                }
                val response = repository.getQuotesRandomRepo().first()
                _responseRandomQuotes.emit(QuotesState.Success(response))
            } else {
                val errorMesssage = "No Internet Connection"
                _responseRandomQuotes.emit(QuotesState.Error(errorMesssage))
            }

        }
    }
}