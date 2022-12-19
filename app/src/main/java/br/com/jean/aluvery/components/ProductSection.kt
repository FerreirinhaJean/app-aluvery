package br.com.jean.aluvery.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.jean.aluvery.R
import br.com.jean.aluvery.model.Product
import java.math.BigDecimal

@Composable
fun ProductSection(name: String) {
    Column {
        Text(
            text = name,
            Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .padding(
                    top = 8.dp,
                )
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Spacer(Modifier)
            ProductItem(
                Product(
                    name = "Hamburguer",
                    price = BigDecimal("14.99"),
                    image = R.drawable.burger
                )
            )
            ProductItem(
                Product(
                    name = "Pizza",
                    price = BigDecimal("17.99"),
                    image = R.drawable.pizza
                )
            )
            ProductItem(
                Product(
                    name = "Batata frita",
                    price = BigDecimal("7.99"),
                    image = R.drawable.fries
                )
            )
            ProductItem(
                Product(
                    name = "Pastel de carne",
                    price = BigDecimal("5.99"),
                )
            )
            Spacer(Modifier)
        }

    }
}

@Preview(
    showBackground = true
)
@Composable
fun ProductSessioPreview(
) {
    ProductSection("Promoções")
}