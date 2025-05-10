package esan.infantes.pc01

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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
fun ConversorScreen(navController: NavHostController) {
    var amount by remember { mutableStateOf("") } // Monto a convertir
    var conversionType by remember { mutableStateOf(ConversionType.USD_TO_PEN) } // Tipo de conversión
    var result by remember { mutableStateOf("") } // Resultado de la conversión
    var errorMessage by remember { mutableStateOf("") } // Mensaje de error si el monto no es válido

    // Tasa fija de conversión
    val conversionRate = 3.80

    // Función para realizar la conversión
    fun convertCurrency(): String {
        val amountValue = amount.toDoubleOrNull()
        if (amountValue == null || amountValue <= 0) {
            errorMessage = "¡El monto debe ser un número positivo!"
            return ""
        }

        errorMessage = ""
        val convertedAmount = when (conversionType) {
            ConversionType.USD_TO_PEN -> amountValue * conversionRate
            ConversionType.PEN_TO_USD -> amountValue / conversionRate
        }

        return String.format("%.2f", convertedAmount)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Conversor de Divisas", style = MaterialTheme.typography.bodyLarge)

        // Campo para ingresar el monto
        TextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Monto a convertir") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            isError = errorMessage.isNotEmpty()
        )
        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = Color.Red, style = MaterialTheme.typography.bodyMedium)
        }

        // Opciones para seleccionar el tipo de conversión (USD a PEN o PEN a USD)
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = conversionType == ConversionType.USD_TO_PEN,
                onClick = { conversionType = ConversionType.USD_TO_PEN }
            )
            Text("USD a PEN", style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = conversionType == ConversionType.PEN_TO_USD,
                onClick = { conversionType = ConversionType.PEN_TO_USD }
            )
            Text("PEN a USD", style = MaterialTheme.typography.bodyMedium)
        }

        // Botón para realizar la conversión
        Button(
            onClick = { result = convertCurrency() },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Convertir")
        }

        // Mostrar el resultado de la conversión
        if (result.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            val currencySymbol = if (conversionType == ConversionType.USD_TO_PEN) "S/." else "$"
            Text("Resultado: $currencySymbol$result", style = MaterialTheme.typography.bodyMedium)
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

// Enum para el tipo de conversión
enum class ConversionType {
    USD_TO_PEN, PEN_TO_USD
}
