package com.example.mvvmjavadagger.di.modules;

import com.example.mvvmjavadagger.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = CatModule.class)
    abstract MainActivity bindLobbyActivity();

    // Add bindings for other sub-components here
}