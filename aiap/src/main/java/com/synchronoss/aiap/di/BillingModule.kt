package com.synchronoss.aiap.di

import android.app.Application
import com.synchronoss.aiap.data.repository.billing.BillingManagerImpl
import com.synchronoss.aiap.domain.usecases.billing.BillingManagerUseCases
import com.synchronoss.aiap.domain.usecases.billing.GetProducts
import com.synchronoss.aiap.domain.usecases.billing.PurchaseSubscription
import com.synchronoss.aiap.domain.repository.billing.BillingManager
import com.synchronoss.aiap.domain.usecases.billing.StartConnection


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