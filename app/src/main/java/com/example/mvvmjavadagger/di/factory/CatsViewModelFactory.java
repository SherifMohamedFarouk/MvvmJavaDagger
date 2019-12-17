package com.example.mvvmjavadagger.di.factory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmjavadagger.di.usecases.LoadCatsUseCase;
import com.example.mvvmjavadagger.viewmodel.ActivityViewModel;


// This factory is what allows the viewModel to has it's dependencies
public class CatsViewModelFactory implements ViewModelProvider.Factory {

    private final LoadCatsUseCase loadCatsUseCase;


    public CatsViewModelFactory(LoadCatsUseCase loadCatsUseCase) {
        this.loadCatsUseCase = loadCatsUseCase;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ActivityViewModel.class)) {
            return (T) new ActivityViewModel(loadCatsUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}