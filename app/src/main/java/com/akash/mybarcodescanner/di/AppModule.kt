package com.akash.mybarcodescanner.di

import android.app.Application
import android.content.Context
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton


@InstallIn(ViewModelComponent::class)
@Module
object AppModule {


    @ViewModelScoped
    @Provides
    fun provideContext(app:Application):Context{
        return app.applicationContext
    }

    @ViewModelScoped
    @Provides
    fun provideBarCodeOptions() : GmsBarcodeScannerOptions{
        return GmsBarcodeScannerOptions.Builder()
            .setBarcodeFormats(Barcode.FORMAT_ALL_FORMATS)
            .build()
    }

    @ViewModelScoped
    @Provides
    fun provideBarCodeScanner(context: Context,options: GmsBarcodeScannerOptions):GmsBarcodeScanner{
        return GmsBarcodeScanning.getClient(context, options)
    }
}