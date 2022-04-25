package developer.vijay.paging3.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import developer.vijay.paging3.retrofit.PassengerAPI
import developer.vijay.paging3.utils.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun getPassengerAPI(retrofit: Retrofit): PassengerAPI {
        return retrofit.create(PassengerAPI::class.java)
    }
}