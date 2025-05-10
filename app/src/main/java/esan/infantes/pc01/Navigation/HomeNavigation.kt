package esan.infantes.pc01.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import esan.infantes.pc01.CalculatorScreen
import esan.infantes.pc01.ConversorScreen
import esan.infantes.pc01.CatalogoScreen

@Composable
fun HomeNavigation(mainNavController: NavHostController) {
    val bottomNavController = rememberNavController()
    val items = listOf(
        BottomNavItem.Calculator,
        BottomNavItem.Catalogo,
        BottomNavItem.Conversor,
    )

    Scaffold(
        bottomBar = { BottomBar(navController = bottomNavController, items = items) }
    ) { padding ->
        NavHost(
            navController = bottomNavController,
            startDestination = BottomNavItem.Catalogo.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(BottomNavItem.Calculator.route) { CalculatorScreen(mainNavController) }
            composable(BottomNavItem.Catalogo.route) { CatalogoScreen(mainNavController) }
            composable(BottomNavItem.Conversor.route) { ConversorScreen(mainNavController) }
        }
    }
}