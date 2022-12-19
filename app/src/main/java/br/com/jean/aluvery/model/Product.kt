package br.com.jean.aluvery.model

import androidx.annotation.DrawableRes
import br.com.jean.aluvery.R
import java.math.BigDecimal

class Product(
    val name: String,
    val price: BigDecimal,
    @DrawableRes
    val image: Int = R.drawable.placeholder
) {

}
