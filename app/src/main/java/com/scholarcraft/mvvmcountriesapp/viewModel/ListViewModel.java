package com.scholarcraft.mvvmcountriesapp.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.scholarcraft.mvvmcountriesapp.model.CountriesService;
import com.scholarcraft.mvvmcountriesapp.model.CountryModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ListViewModel extends ViewModel {
    public MutableLiveData<List<CountryModel>> countries = new MutableLiveData<List<CountryModel>>();
    public MutableLiveData<Boolean> countryLoadError = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();

    private CountriesService countriesService = CountriesService.getInstance();

    private CompositeDisposable disposable = new CompositeDisposable();

    public void refresh() {
        fetchCountries();
    }

    private void fetchCountries() {
        loading.setValue(true);
        disposable.add(
                countriesService.getCountries()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<List<CountryModel>>() {

                            @Override
                            public void onSuccess(@NonNull List<CountryModel> countryModels) {

                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }
                        })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

    //        // mock data used for testing, prior to api integration
//        CountryModel country1 = new CountryModel("Albania", "Tirana", "");
//        CountryModel country2 = new CountryModel("Algeria", "Algiers", "");
//        CountryModel country3 = new CountryModel("Australia", "Canberra", "");
//        CountryModel country4 = new CountryModel("Brazil", "Brazilia", "");
//        CountryModel country5 = new CountryModel("Egypt", "Cairo", "");
//        CountryModel country6 = new CountryModel("Italy", "Rome", "");
//        CountryModel country7 = new CountryModel("Lebanon", "Beirut", "");
//        CountryModel country8 = new CountryModel("New Mexico", "Mexico City", "");
//        CountryModel country9 = new CountryModel("Saudi Arabia", "Riyadh", "");
//        CountryModel country10 = new CountryModel("South Africa", "Cape Town", "");
//        CountryModel country11 = new CountryModel("Spain", "Madrid", "");
//        CountryModel country12 = new CountryModel("UAE", "Abu Dhabi", "");
//        CountryModel country13 = new CountryModel("USA", "Washington D.C.", "");
//
//        List<CountryModel> list = new ArrayList<>();
//        list.add(country1);
//        list.add(country2);
//        list.add(country3);
//        list.add(country4);
//        list.add(country5);
//        list.add(country6);
//        list.add(country7);
//        list.add(country8);
//        list.add(country9);
//        list.add(country10);
//        list.add(country11);
//        list.add(country12);
//        list.add(country13);
//
//        countries.setValue(list);
//        countryLoadError.setValue(false);
//        loading.setValue(false);
}
