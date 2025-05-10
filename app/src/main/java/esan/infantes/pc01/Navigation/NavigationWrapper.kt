package esan.infantes.pc01.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import esan.infantes.pc01.CalculatorScreen
import esan.infantes.pc01.CatalogoScreen
import esan.infantes.pc01.ConversorScreen

@Composable
fun NavigationWrapper(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(BottomNavItem.Calculator.route) { CalculatorScreen(navController) }
        composable(BottomNavItem.Catalogo.route) { CatalogoScreen(navController) }
        composable(BottomNavItem.Conversor.route) { ConversorScreen(navController) }
    }
}