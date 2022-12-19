package br.com.jean.aluvery.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.jean.aluvery.extensions.toBrazilCurrency
import br.com.jean.aluvery.model.Product
import br.com.jean.aluvery.ui.theme.AluveryTheme
import br.com.jean.aluvery.ui.theme.Purple500
import br.com.jean.aluvery.ui.theme.Teal200
import java.math.BigDecimal

@Composable
fun ProductItem(product: Product) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple500,
                                Teal200
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = "Imagem do produto",
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop,
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(
                modifier =
                Modifier.padding(16.dp)
            ) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price.toBrazilCurrency(),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun ProductItemPreview() {
    AluveryTheme {
        Surface {
            ProductItem(
                Product(
                    name = "Pizza de Calabresa",
                    price = BigDecimal("14.99")
                )
            )
        }

    }
}