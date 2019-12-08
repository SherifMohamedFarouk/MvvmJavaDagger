package com.example.mvvmjavadagger.models;

import androidx.annotation.NonNull;

import com.example.mvvmjavadagger.models.enums.Status;

import java.util.ArrayList;

import io.reactivex.annotations.Nullable;

import static com.example.mvvmjavadagger.models.enums.Status.ERROR;
import static com.example.mvvmjavadagger.models.enums.Status.LOADING;
import static com.example.mvvmjavadagger.models.enums.Status.SUCCESS;

public class Response {
    @Nullable
    public final ArrayList<CatModel> catList;
    @Nullable
    public final Throwable throwable;

    public final Status status;

    public Response( @Nullable ArrayList<CatModel> catList,  @Nullable Throwable throwable, Status status) {
        this.catList = catList;
        this.throwable = throwable;
        this.status = status;
    }
    public static Response Loading(){
        return  new Response(null,null ,LOADING);
    }
    public static Response Success(@NonNull ArrayList<CatModel> data){
        return new Response(data,null,SUCCESS);
    }
    public static Response Error(@NonNull Throwable error){
        return new Response(null,error,ERROR);
    }


}
