package hu.tb.firebasetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import hu.tb.firebasetesting.ui.theme.FirebaseTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseTestingTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting(mainViewModel: MainViewModel = viewModel()) {
    mainViewModel.register()
    //mainViewModel.writeData()
    //mainViewModel.readData()
    Text(
        text = "Hello",
    )
}