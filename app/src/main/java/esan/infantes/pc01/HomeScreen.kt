package esan.infantes.pc01

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import esan.infantes.pc01.Navigation.BottomNavItem
import esan.infantes.pc01.Navigation.Screens

@Composable

fun HomeScreen(navController: NavHostController){
    //Agregar boton que redirija a la calculadora
    //Button Iniciar Sesión
    Button(
        onClick = { navController.navigate(Screens.Calculator.route) },
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF00C853),
            contentColor = Color.White
        ),
    ) {
        Text("Calculadora",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFFFFFFFF),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

    }
    //Button Iniciar Sesión
    Button(
        onClick = { navController.navigate(Screens.Catalogo.route) },
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF00C853),
            contentColor = Color.White
        ),
    ) {
        Text("Catalogo",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFFFFFFFF),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

    }
    //Button Iniciar Sesión
    Button(
        onClick = { navController.navigate(Screens.Conversor.route) },
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF00C853),
            contentColor = Color.White
        ),
    ) {
        Text("Conversor",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFFFFFFFF),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

    }
}