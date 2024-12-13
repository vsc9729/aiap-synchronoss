package com.geekyants.tippy.billingManager.domain.usecases.billing

import com.android.billingclient.api.ProductDetails
import com.geekyants.tippy.billingManager.domain.repository.billing.BillingManager
import javax.inject.Inject

class GetProducts(
    private val billingManager: BillingManager
) {
    suspend operator fun invoke(
        productIds: List<String>,
        onProductsReceived: (List<ProductDetails>) -> Unit,
        onError: (String) -> Unit
    ) {
        billingManager.getProducts(
            productIds = productIds,
            onProductsReceived = onProductsReceived,
            onError = onError
        )
    }
}