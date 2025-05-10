package esan.infantes.pc01

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import esan.infantes.pc01.Navigation.Screens

data class Product(
    val name: String,
    val price: Double,
    val category: String,
    val imageUrl: String
)

@Composable
fun CatalogoScreen(navController: NavHostController) {
    // Lista de productos
    val products = listOf(
        Product("Laptop Dell", 4500.0, "Laptop", "https://linktoimage.com/laptop.jpg"),
        Product("Smartphone Samsung", 1800.0, "Smartphone", "https://linktoimage.com/smartphone.jpg"),
        Product("Auriculares Bose", 350.0, "Accesorio", "https://linktoimage.com/auriculares.jpg"),
        Product("Tablet iPad", 2300.0, "Tablet", "https://linktoimage.com/tablet.jpg")
    )

    // Cálculo del total acumulado
    val total = products.sumOf { it.price }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            "Catálogo de Productos Tecnológicos",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp) // Espaciado adicional
        )

        // Botón regresar a Home
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
            Text(
                "Regresar",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // LazyColumn para mostrar los productos
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(products) { product ->
                ProductCard(product)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar el total acumulado
        Text(
            text = "Total: S/. ${"%.2f".format(total)}",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))


    }
}

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp) // Asegura que las esquinas estén redondeadas
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            // Imagen del producto
            Image(
                painter = rememberImagePainter(product.imageUrl),
                contentDescription = product.name,
                modifier = Modifier
                    .size(100.dp) // Tamaño de la imagen
                    .clip(RoundedCornerShape(8.dp)), // Redondeo de la imagen
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Información del producto
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Precio: S/. ${"%.2f".format(product.price)}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                Text(
                    text = "Categoría: ${product.category}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
    }
}
