package com.geekyants.tippy.billingManager.di

import android.app.Application
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.Purchase
import com.geekyants.tippy.billingManager.data.repository.billing.BillingManagerImpl
import com.geekyants.tippy.billingManager.domain.repository.billing.BillingManager
import com.geekyants.tippy.billingManager.domain.usecases.billing.BillingManagerUseCases
import com.geekyants.tippy.billingManager.domain.usecases.billing.GetProducts
import com.geekyants.tippy.billingManager.domain.usecases.billing.PurchaseSubscription
import com.geekyants.tippy.billingManager.domain.usecases.billing.StartConnection


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object BillingModule {
    @Provides
    @Singleton
    fun provideBillingManager(
        application: Application
    ): BillingManager {
        return BillingManagerImpl(application)
    }

    @Provides
    @Singleton
    fun provideBillingManagerUseCases(billingManager: BillingManager): BillingManagerUseCases {
        return BillingManagerUseCases(
            startConnection = StartConnection(billingManager),
            getProducts = GetProducts(billingManager),
            purchaseSubscription = PurchaseSubscription(billingManager)
        )
    }

}