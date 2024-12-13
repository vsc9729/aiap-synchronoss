import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.billingclient.api.ProductDetails
import com.synchronoss.aiap.presentation.SubscriptionsViewModel

import kotlinx.coroutines.runBlocking

@Composable
fun SubscriptionsView(modifier: Modifier = Modifier) {
    val subscriptionsViewModel = hiltViewModel<SubscriptionsViewModel>()


    runBlocking {
        subscriptionsViewModel.startConnection(
            productIds = listOf(
                "iap_yearly_1499",
                "test_product"
            )
        )
    }
    val products: List<ProductDetails>? = subscriptionsViewModel.products
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Products", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))
        products?.forEach { product ->
            Text(
                product.name,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(4.dp)
                    .clickable {

                    })
            Spacer(modifier = modifier.height(4.dp))
        }
    }
}