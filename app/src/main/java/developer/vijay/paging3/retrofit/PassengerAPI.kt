package developer.vijay.paging3.retrofit

import developer.vijay.paging3.models.PassengerList
import retrofit2.http.GET
import retrofit2.http.Query

interface PassengerAPI {

    @GET("passenger")
    suspend fun getPassengers(
        @Query("page") page: Int,
        @Query("size") size: Int = 10
    ): PassengerList

}