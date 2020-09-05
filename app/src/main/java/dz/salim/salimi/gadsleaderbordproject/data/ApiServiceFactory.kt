package dz.salim.salimi.gadsleaderbordproject.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceFactory {
    private const val BASE_URL = "https://gadsapi.herokuapp.com/"

    fun getInstance(): LeadersApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LeadersApiService::class.java)
    }
}