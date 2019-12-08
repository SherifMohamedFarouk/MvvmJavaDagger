package com.example.mvvmjavadagger.viewmodel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmjavadagger.models.Response;
import com.example.mvvmjavadagger.repositories.CatRepositery;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ActivityViewModel extends ViewModel {

    CatRepositery catRepositery = new CatRepositery() ;

    Disposable compositeDisposable = new CompositeDisposable();

    public MutableLiveData<Response> response = new MutableLiveData<>();
    public MutableLiveData<Integer>  progressBarVisibility = new MutableLiveData<>();



    public void getCats(){
        compositeDisposable = catRepositery.getCats(3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete(this::doOnComplete).
                        subscribe(
                 catModelArrayList -> response.setValue(Response.Success(catModelArrayList)),
                  throwable -> response.setValue(Response.Error(throwable))

                        );
        }



    private void doOnComplete() {
        progressBarVisibility.setValue(View.GONE);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();

    }

}
