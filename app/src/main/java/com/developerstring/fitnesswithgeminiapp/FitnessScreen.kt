package com.developerstring.fitnesswithgeminiapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessScreen(
    fitnessViewModel: FitnessViewModel = viewModel()
) {

    val prompt = remember {
        mutableStateOf("")
    }

    val generatedText = fitnessViewModel.generatedText.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Fitness With Gemini")
                },
                actions = {
                    Icon(
                        modifier = Modifier.padding(end = 10.dp),
                        imageVector = Icons.Default.Share,
                        contentDescription = null
                    )
                }
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Card(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
            ) {

                Text(modifier = Modifier.padding(all = 20.dp).verticalScroll(state = rememberScrollState()), text =  generatedText)

            }

            Row(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedTextField(
                    value = prompt.value,
                    onValueChange = {
                        prompt.value = it
                    },
                    label = {
                        Text(text = "Enter Prompt")
                    },
                    placeholder = {
                        Text(text = "Enter Prompt")
                    },
                    singleLine = false,
                    modifier = Modifier.fillMaxWidth(0.85f)
                )

                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send",
                    modifier = Modifier.size(28.dp)
                        .clickable {
                            fitnessViewModel.sendPrompt(prompt = prompt.value)
                        },
                )

            }

        }
    }


}

@Preview(showSystemUi = true)
@Composable
fun FitnessScreenPreview() {
    FitnessScreen()
}