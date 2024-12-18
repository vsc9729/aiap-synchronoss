package com.synchronoss.aiap.domain.usecases.billing

import androidx.activity.ComponentActivity
import com.android.billingclient.api.ProductDetails
import com.synchronoss.aiap.domain.repository.billing.BillingManager

class PurchaseSubscription(
    private val billingManager: BillingManager
) {
    suspend operator fun invoke(
        activity: ComponentActivity,
        product: ProductDetails,
        onError: (String) -> Unit
    ) {
        billingManager.purchaseSubscription(
            activity = activity,
            product = product,
            onError = onError
        )
    }
}