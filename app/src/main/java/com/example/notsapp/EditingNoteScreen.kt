package com.example.notsapp


    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.wrapContentHeight
    import androidx.compose.foundation.layout.wrapContentSize
    import androidx.compose.material3.OutlinedButton
    import androidx.compose.material3.OutlinedTextField
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.navigation.NavController
    import androidx.navigation.compose.rememberNavController
    import androidx.lifecycle.viewmodel.compose.viewModel
    import com.example.notsapp.database.Note
    import com.example.notsapp.ui.NoteViewModel

@Composable
    fun EditingNoteScreen(
        id: Int,
        noteDetails: String,
        noteTitle: String,
        modifier: Modifier = Modifier,
        navController: NavController,
        viewModel: NoteViewModel = viewModel()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 32.dp, start = 16.dp, end = 16.dp)
        ) {
            var details by remember { mutableStateOf(noteDetails) }
            var title by remember { mutableStateOf(noteTitle) }

            OutlinedTextField(value = title,
                onValueChange ={title=it},
                label = { Text(text = "Title")}
            ,modifier=modifier
                .wrapContentHeight(Alignment.Top))

            OutlinedTextField(
                value = details,
                onValueChange = { details = it },
                label = {
                    Text(text = "Note Details")
                },
                modifier = modifier.fillMaxWidth()
            )

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
            ) {
                OutlinedButton(
                    onClick = {
                    viewModel.upseretNote(Note(id,details,title))
                        navController.popBackStack() // Go back to the previous screen
                    },
                    modifier = modifier
                        .weight(1f)
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(text = "Update")
                }
                OutlinedButton(
                    onClick = {
                    viewModel.deleteNote(Note(id,noteDetails,noteTitle))
                        navController.popBackStack() // Go back to the previous screen
                    },
                    modifier = modifier
                        .weight(1f)
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(text = "Delete")
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
private fun EditingNoteScreenPreview() {
    EditingNoteScreen(id = 2, noteDetails = "test details", noteTitle = "test title", navController = rememberNavController())
}