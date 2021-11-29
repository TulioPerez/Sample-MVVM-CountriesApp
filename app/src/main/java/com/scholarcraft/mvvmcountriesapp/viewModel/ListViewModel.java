package com.scholarcraft.mvvmcountriesapp.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.scholarcraft.mvvmcountriesapp.model.CountryModel;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {
    public MutableLiveData<List<CountryModel>> countries = new MutableLiveData<List<CountryModel>>();
    public MutableLiveData<Boolean> countryLoadError = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();

    public void refresh() {
        fetchCountries();
    }

    private void fetchCountries() {
        //temp values will be changed after api integration... this is mock data
        CountryModel country1 = new CountryModel("Albania", "Tirana", "");
        CountryModel country2 = new CountryModel("Algeria", "Algiers", "");
        CountryModel country3 = new CountryModel("Australia", "Canberra", "");
        CountryModel country4 = new CountryModel("Brazil", "Brazilia", "");
        CountryModel country5 = new CountryModel("Egypt", "Cairo", "");
        CountryModel country6 = new CountryModel("Italy", "Rome", "");
        CountryModel country7 = new CountryModel("Lebanon", "Beirut", "");
        CountryModel country8 = new CountryModel("New Mexico", "Mexico City", "");
        CountryModel country9 = new CountryModel("Saudi Arabia", "Riyadh", "");
        CountryModel country10 = new CountryModel("South Africa", "Cape Town", "");
        CountryModel country11 = new CountryModel("Spain", "Madrid", "");
        CountryModel country12 = new CountryModel("UAE", "Abu Dhabi", "");
        CountryModel country13 = new CountryModel("USA", "Washington D.C.", "");

        List<CountryModel> list = new ArrayList<>();
        list.add(country1);
        list.add(country2);
        list.add(country3);
        list.add(country4);
        list.add(country5);
        list.add(country6);
        list.add(country7);
        list.add(country8);
        list.add(country9);
        list.add(country10);
        list.add(country11);
        list.add(country12);
        list.add(country13);

        countries.setValue(list);
        countryLoadError.setValue(false);
        loading.setValue(false);
    }
}
