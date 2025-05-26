package dev.himanshu.recipes


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import dev.himanshu.recipes.ui.theme.RecipesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        //navegacion()
            segundaActivity({
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)

            })
        }
    }
}
@Composable
fun segundaActivity(onClick: () -> Unit) {
    Text("segunda pantalla", modifier = Modifier.fillMaxSize())
    Button(onClick) {
        Text("Ir a la 2da pantalla")
    }
}

//########################################################################
/*data class Dummy(
    val id:Int,
    val name: String
)

sealed interface Dest{
    data object FirstScreen

    data class SecondScreen(
        val id:Int,
        val dummy: Dummy
    )

}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            RecipesTheme {

                val backStack = remember{ mutableStateListOf<Any>(Dest.FirstScreen) }

                NavDisplay(backStack = backStack,
                    onBack = {backStack.removeLastOrNull()},
                    entryProvider = entryProvider {
                        entry<Dest.FirstScreen> {key->
                            FirstScreen(modifier = Modifier.fillMaxSize()) {
                                backStack.add(Dest.SecondScreen(
                                    12, Dummy(34,"Himanshu")
                                ))
                            }
                        }
                        entry<Dest.SecondScreen> { key->
                            SecondScreen(modifier = Modifier.fillMaxSize(), id = key.id,
                                dummy = key.dummy) {
                                backStack.removeLastOrNull()
                            }
                        }
                    })


            }
        }
    }
}

@Composable
fun FirstScreen(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(
        modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("First Screen")
        Spacer(Modifier.height(12.dp))
        Button(onClick) {
            Text("Go to second screen")
        }

    }
}



@Composable
fun SecondScreen(modifier: Modifier = Modifier,
                 id:Int,
                 dummy: Dummy,
                 onClick: () -> Unit) {
    Column(
        modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Second Screen ${id} ${dummy.name} ${dummy.id}")
        Spacer(Modifier.height(12.dp))
        Button(onClick) {
            Text("Go to first screen")
        }

    }
}
*/