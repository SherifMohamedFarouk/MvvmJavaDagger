package com.example.mvvmjavadagger.di.modules;

import android.content.Context;

import com.example.mvvmjavadagger.MyApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    Context provideContext(MyApplication application) {
        return application.getApplicationContext();
    }
}