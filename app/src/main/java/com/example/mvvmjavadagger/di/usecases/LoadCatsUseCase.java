package com.example.mvvmjavadagger.di.usecases;


import com.example.mvvmjavadagger.models.CatModel;
import com.example.mvvmjavadagger.repositories.CatRepositery;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;

public class LoadCatsUseCase {
    private final CatRepositery catRepository;

    @Inject
    public LoadCatsUseCase(CatRepositery catRepository) {
        this.catRepository = catRepository;
    }

    public Observable<ArrayList<CatModel>> execute() {
        return catRepository.getCats(3);
    }
}