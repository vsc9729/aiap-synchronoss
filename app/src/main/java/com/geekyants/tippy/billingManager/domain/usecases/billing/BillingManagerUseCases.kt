package com.geekyants.tippy.billingManager.domain.usecases.billing

import javax.inject.Inject

data class BillingManagerUseCases(
    val startConnection: StartConnection,
    val getProducts: GetProducts,
    val purchaseSubscription: PurchaseSubscription,
)
