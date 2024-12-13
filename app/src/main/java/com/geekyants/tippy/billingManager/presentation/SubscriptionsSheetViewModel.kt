package com.geekyants.tippy.billingManager.presentation


import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.billingclient.api.ProductDetails
import com.geekyants.tippy.billingManager.domain.usecases.billing.BillingManagerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SubscriptionsViewModel @Inject constructor(
    private val billingManagerUseCases: BillingManagerUseCases
) : ViewModel() {

    var products: List<ProductDetails>? by mutableStateOf(null)
    
    suspend fun startConnection(productIds: List<String>) {
        billingManagerUseCases.startConnection(
            {
                viewModelScope.launch {
                    getProducts(productIds = productIds, onError = {
                        Log.d("Co", "Failed to fetch products");
                    })
                }
            },
            {
                Log.d("Co", "Failed to connect to billing service");
            },
        )
    }

    suspend fun getProducts(
        productIds: List<String>,
        onError: (String) -> Unit
    ) {
        billingManagerUseCases.getProducts(
            productIds = productIds,
            onProductsReceived = { products = it },
            onError = onError
        )
    }

    suspend fun purchaseSubscription(
        activity: ComponentActivity,
        product: ProductDetails,
        onError: (String) -> Unit
    ) {
        billingManagerUseCases.purchaseSubscription(activity, product, onError)
    }

}