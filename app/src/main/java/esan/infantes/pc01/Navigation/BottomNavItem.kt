package esan.infantes.pc01.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val title: String) {
    object Catalogo : BottomNavItem("catalogo", Icons.Default.ShoppingCart, "Catalogo")
    object Calculator : BottomNavItem("calculator", Icons.Default.MailOutline, "Calculadora")
    object Conversor : BottomNavItem("conversor", Icons.Default.LocationOn, "Conversor")
}