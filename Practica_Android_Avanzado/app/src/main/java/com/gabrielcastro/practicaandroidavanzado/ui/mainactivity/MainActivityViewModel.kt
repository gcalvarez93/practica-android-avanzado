package com.gabrielcastro.practicaandroidavanzado.ui.mainactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabrielcastro.practicaandroidavanzado.data.RepositoryImpl
import com.gabrielcastro.practicaandroidavanzado.ui.mainactivity.model.Heroe
import com.gabrielcastro.practicaandroidavanzado.ui.mainactivity.model.Location
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

//class MainActivityViewModel(private val token: String) : ViewModel() {
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repositoryImpl :RepositoryImpl
) : ViewModel() {


    //LiveData states mannagers:
    //HeroesList
    private val _heroes = MutableLiveData<List<Heroe>>()
    val heroes: LiveData<List<Heroe>> get () = _heroes

    //HeroeDetail
    private val _heroe = MutableLiveData<Heroe>()
    val heroe : LiveData<Heroe> get () = _heroe

    //HeroeLocations
    private val _locations = MutableLiveData<List<Location>>()
    val locations : LiveData<List<Location>> get () = _locations

    //Retrieve heroes from API:

    fun getHeroes(){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repositoryImpl.getHeroes()
            }
            _heroes.value = result
        }
    }

    //Retrieve heroe with id

    fun getHeroe(id: String){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repositoryImpl.getHeroe(id)
            }
            _heroe.value = result
        }
    }

    fun updateHeroeFavStateLocalAndRemote(id: String, isFav: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryImpl.updateHeroeFavStateLocalAndRemote(id, isFav)
        }
    }

    fun retrieveHeroeLocations(id: String){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repositoryImpl.retrieveHeroeLocations(id)
            }
            if (result.isNotEmpty()){
                _locations.value = result
            }
        }
    }
}