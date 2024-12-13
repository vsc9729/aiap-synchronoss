package com.geekyants.tippy.billingManager.domain.usecases.billing

import com.geekyants.tippy.billingManager.domain.repository.billing.BillingManager

class StartConnection(
    private val billingManager: BillingManager
) {
    suspend operator fun invoke(onConnected: () -> Unit, onDisconnected: () -> Unit) {
        billingManager.startConnection(onConnected = onConnected, onDisconnected = onDisconnected)
    }
    
}