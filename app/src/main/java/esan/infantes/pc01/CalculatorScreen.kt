
package esan.infantes.pc01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import esan.infantes.pc01.Navigation.Screens

@Composable
fun CalculatorScreen(navController: NavHostController) {
    var ageHuman by remember { mutableStateOf("") }
    var dogAge by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var selectedDogSize by remember { mutableStateOf("Pequeno") } // Tamaño seleccionado por defecto
    val dogSizes = listOf("Pequeno", "Mediano", "Grande")

    // Estado para controlar la visibilidad del DropdownMenu
    var isDropdownExpanded by remember { mutableStateOf(false) }

    // Función para calcular la edad del perro
    fun calculateDogAge(): String {
        val age = ageHuman.toIntOrNull()
        if (age == null || age <= 0) {
            errorMessage = "¡La edad debe ser un número positivo!"
            return ""
        }

        errorMessage = ""
        val dogAgeInYears = when (selectedDogSize) {
            "Pequeno" -> age * 5
            "Mediano" -> age * 6
            "Grande" -> age * 7
            else -> 0
        }

        return "$dogAgeInYears años perro. ¡Es una mascota súper madura!"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Calculadora de Edad Canina", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        // Campo para ingresar la edad humana del perro
        TextField(
            value = ageHuman,
            onValueChange = { ageHuman = it },
            label = { Text("Edad del perro (años humanos)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            isError = errorMessage.isNotEmpty()
        )

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar el tamaño del perro seleccionado
        Text("Tamaño del perro: $selectedDogSize", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para abrir el DropdownMenu
        Button(
            onClick = { isDropdownExpanded = !isDropdownExpanded }
        ) {
            Text("Seleccionar tamaño del perro")
        }

        // Dropdown para seleccionar el tamaño del perro
        DropdownMenu(
            expanded = isDropdownExpanded,
            onDismissRequest = { isDropdownExpanded = false }
        ) {
            dogSizes.forEach { size ->
                DropdownMenuItem(
                    text = { Text(text = size) },
                    onClick = {
                        selectedDogSize = size
                        isDropdownExpanded = false
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para calcular la edad del perro
        Button(
            onClick = { dogAge = calculateDogAge() }
        ) {
            Text("Calcular Edad Perro")
        }

        // Mostrar resultado
        if (dogAge.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "La edad de tu perro es: $dogAge",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
    //Boton regresar a Home
    Button(
        onClick = { navController.navigate(Screens.Home.route) },
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF00C853),
            contentColor = Color.White
        ),
    ) {
        Text("Regresar",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFFFFFFFF),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

    }


}