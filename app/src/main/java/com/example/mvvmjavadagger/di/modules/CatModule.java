package com.example.mvvmjavadagger.di.modules;


import com.example.mvvmjavadagger.di.factory.CatsViewModelFactory;
import com.example.mvvmjavadagger.di.usecases.LoadCatsUseCase;
import com.example.mvvmjavadagger.repositories.CatRepositery;

import dagger.Module;
import dagger.Provides;

@Module
public class CatModule {

    @Provides
    CatRepositery provideCatRepository() {
        return new CatRepositery();
    }

    @Provides
    CatsViewModelFactory provideLobbyViewModelFactory(LoadCatsUseCase loadCatsUseCase) {
        return new CatsViewModelFactory(loadCatsUseCase);
    }
}