package com.example.mvvmjavadagger.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmjavadagger.R;
import com.example.mvvmjavadagger.models.CatModel;
import com.example.mvvmjavadagger.models.Response;
import com.example.mvvmjavadagger.viewmodel.ActivityViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.mvvmjavadagger.models.enums.Status.LOADING;
import static com.example.mvvmjavadagger.models.enums.Status.SUCCESS;
import static com.example.mvvmjavadagger.models.enums.Status.ERROR;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mainProgressBar)
    ProgressBar mainProgressBar;
    @BindView(R.id.catsRecyclerView)
    RecyclerView catsRecyclerView;

    CatAdapter catAdapter = new CatAdapter(new ArrayList<>());

    ActivityViewModel activityViewModel = new ActivityViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // initializing recyclerview with required parameters
        initiateRecyclerView();
        // initiate ViewModel
//        initiateViewModel();
        // initiate Observer
        initiateObservers();
        // initiate call of network to get the cats
        getMyCats();

    }


    private void initiateRecyclerView() {
        // initializing catAdapter with empty list
        catAdapter = new CatAdapter(new ArrayList<>());
        // apply allows you to alter variables inside the object and assign them
        catsRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        catsRecyclerView.setAdapter(catAdapter);
    }

//    private void initiateViewModel() {
//        // this is how we initialize viewModel
//        activityViewModel = ViewModelProviders.of(this, activityViewModel).get(activityViewModel.class);
//    }

    private void initiateObservers() {

        activityViewModel.response.observe(this, this::processResponse);
    }

    private void getMyCats() {
        activityViewModel.getCats();
    }

    private void processResponse(Response response) {
        switch (response.status) {
            case LOADING:
                renderLoadingState();
                break;

            case SUCCESS:
                renderDataState(response.catList);
                break;

            case ERROR:
                renderErrorState(response.throwable);
                break;
        }
    }


    private void renderLoadingState() {
        mainProgressBar.setVisibility(View.VISIBLE);
    }

    private void renderDataState(ArrayList<CatModel> catModels) {
        mainProgressBar.setVisibility(View.GONE);

        if (catModels != null && catModels.size() > 0) {
            catAdapter.data.addAll(catModels);
            catAdapter.notifyDataSetChanged();

        } else {
            Toast.makeText(this, "No data found!", Toast.LENGTH_SHORT).show();
        }
    }

    private void renderErrorState(Throwable throwable) {
        mainProgressBar.setVisibility(View.GONE);
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }


}
