package com.gabrielcastro.practicaandroidavanzado.data.mappers

import com.gabrielcastro.practicaandroidavanzado.data.remote.GetLocationsResponse
import com.gabrielcastro.practicaandroidavanzado.ui.mainactivity.model.Location
import javax.inject.Inject

class GetLocationsResponseToLocations @Inject constructor() {
    fun mapFromGetLocationsResponseToLocations(getLocationsResponseList: List<GetLocationsResponse>) : List<Location>{
        return getLocationsResponseList.map {mspFromGetLocationResponseToLocation(it)}
    }

    private  fun mspFromGetLocationResponseToLocation(getLocationResponse: GetLocationsResponse): Location {
        return Location(getLocationResponse.id, getLocationResponse.dateShow,getLocationResponse.latitud,getLocationResponse.longitud)
    }

}