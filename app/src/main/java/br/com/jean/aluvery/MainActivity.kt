package br.com.jean.aluvery

import android.icu.text.ListFormatter.Width
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.jean.aluvery.extensions.toBrazilCurrency
import br.com.jean.aluvery.model.Product
import br.com.jean.aluvery.ui.theme.AluveryTheme
import br.com.jean.aluvery.ui.theme.Purple500
import br.com.jean.aluvery.ui.theme.Teal200
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProductSession("Promoções")
        ProductSession("Doces")
        ProductSession("Salgados")
    }
}

@Composable
fun ProductSession(name: String) {
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
                        .align(BottomCenter),
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
    showSystemUi = true
)
@Composable
fun AppPreview() {
    App()
}


@Preview(
    showBackground = true
)
@Composable
fun ProductItemPreview() {
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

@Preview(
    showBackground = true
)
@Composable
fun ProductSessioPreview(
) {
    ProductSession("Promoções")
}