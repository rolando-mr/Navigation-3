package dev.himanshu.recipes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay

data object PrimerScreen
data object SegundoScreen
data object TercerScreen

@Composable
@Preview
fun navegacion(){
    val backStack = remember{ mutableStateListOf<Any>(PrimerScreen) }

    NavDisplay(backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider = entryProvider {
            entry<PrimerScreen> { key->
                PrimerScreen(onClick = {
                    backStack.add(SegundoScreen)
                    backStack.remove(PrimerScreen)
                },
                    onClick2 = {
                        backStack.add(TercerScreen)
                        backStack.remove(PrimerScreen)
                    },)
            }
            entry<SegundoScreen> { key->
                SegundoScreen() {
                    backStack.remove(SegundoScreen)
                    backStack.add(TercerScreen)
                }
            }
            entry<TercerScreen> { key->
                TercerScreen() {
                    backStack.remove(TercerScreen)
                    //backStack.remove(SecondScreen)
                    backStack.add(PrimerScreen)
                }
            }
        })
}

@Composable
fun PrimerScreen( onClick: () -> Unit, onClick2: () -> Unit) {
    Column(
        Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("inicio")
        Spacer(Modifier.height(12.dp))
        Button(onClick) {
            Text("ir a segunda pantalla")
        }
        Spacer(Modifier.height(12.dp))
        Button(onClick2) {
            Text("ir a tercera pantalla")
        }

    }
}

@Composable
fun SegundoScreen( onClick: () -> Unit) {
    Column(
        Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("segunda pantalla")
        Spacer(Modifier.height(12.dp))
        Button(onClick) {
            Text("ir a tercera pantalla")
        }

    }
}
@Composable
fun TercerScreen( onClick: () -> Unit) {
    Column(
        Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("tercera pantalla")
        Spacer(Modifier.height(12.dp))
        Button(onClick) {
            Text("volver al inicio")
        }

    }
}