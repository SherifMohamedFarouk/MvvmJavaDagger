package com.example.mvvmjavadagger.di.factory.components;



import com.example.mvvmjavadagger.MyApplication;
import com.example.mvvmjavadagger.di.modules.AppModule;
import com.example.mvvmjavadagger.di.modules.BuildersModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        BuildersModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(MyApplication application);
        AppComponent build();
    }
    void inject(MyApplication app);
}