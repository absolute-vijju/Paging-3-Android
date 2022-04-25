package developer.vijay.paging3.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import developer.vijay.paging3.paging.PagingSource
import developer.vijay.paging3.retrofit.PassengerAPI
import javax.inject.Inject

class PassengerRepository @Inject constructor(private val passengerAPI: PassengerAPI) {

    fun getPassengers() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { PagingSource(passengerAPI) }
    ).liveData
}