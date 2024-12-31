package com.developerstring.fitnesswithgeminiapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FitnessViewModel : ViewModel() {

    private val generativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = BuildConfig.apiKey
    )

    var generatedText: MutableState<String> = mutableStateOf("Enter Some Prompt and click on send icon, to generate some fitness content!")

    fun sendPrompt(
        prompt: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = generativeModel.generateContent(
                    content {
                        text(prompt)
                    }
                )
                response.text?.let { outputContent ->
                    generatedText.value = outputContent
                }
            } catch (e: Exception) {
                generatedText.value = "Error Occurred! Please Try again."
            }
        }
    }
}