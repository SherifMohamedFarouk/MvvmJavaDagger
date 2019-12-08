package com.example.mvvmjavadagger.repositories;

import com.example.mvvmjavadagger.models.CatModel;
import com.example.mvvmjavadagger.services.CatApi;

import java.util.ArrayList;
import io.reactivex.Observable;

import static com.example.mvvmjavadagger.utils.NetworkUtils.createWebService;

public class CatRepositery {
    private CatApi catApi = createWebService();

    public Observable<ArrayList<CatModel>>getCats(int limit){

        return catApi.getCats(limit);

    }
}
