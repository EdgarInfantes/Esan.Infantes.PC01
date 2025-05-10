package esan.infantes.pc01

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import esan.infantes.pc01.Navigation.Screens

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Espaciado alrededor
        verticalArrangement = Arrangement.spacedBy(12.dp) // Espaciado entre los botones
    ) {
        // Botón de la Calculadora
        Button(
            onClick = { navController.navigate(Screens.Calculator.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00C853),
                contentColor = Color.White
            ),
        ) {
            Text(
                "Calculadora",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFFFFFFFF),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Divider() // Separador entre botones

        // Botón del Catálogo
        Button(
            onClick = { navController.navigate(Screens.Catalogo.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00C853),
                contentColor = Color.White
            ),
        ) {
            Text(
                "Catálogo",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFFFFFFFF),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Divider() // Separador entre botones

        // Botón del Conversor
        Button(
            onClick = { navController.navigate(Screens.Conversor.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00C853),
                contentColor = Color.White
            ),
        ) {
            Text(
                "Conversor",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFFFFFFFF),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
