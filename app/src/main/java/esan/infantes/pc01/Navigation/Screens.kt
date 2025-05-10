package esan.infantes.pc01.Navigation



sealed class Screens(val route: String) {
    object Calculator : Screens("calculator")
    object Catalogo : Screens("catalogo")
    object Conversor : Screens("conversor")
    object Home : Screens("home")

}