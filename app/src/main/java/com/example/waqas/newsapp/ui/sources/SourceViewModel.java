package com.example.waqas.newsapp.ui.sources;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import com.example.waqas.newsapp.data.NewsRepository;
import com.example.waqas.newsapp.models.Source;
import com.example.waqas.newsapp.models.Specification;

import java.util.List;

public class SourceViewModel extends AndroidViewModel {
    private final NewsRepository newsRepository;

    public SourceViewModel(@NonNull Application application) {
        super(application);
        this.newsRepository = NewsRepository.getInstance(application.getApplicationContext());
    }

    LiveData<List<Source>> getSource(Specification specification) {
        return newsRepository.getSources(specification);
    }
}
