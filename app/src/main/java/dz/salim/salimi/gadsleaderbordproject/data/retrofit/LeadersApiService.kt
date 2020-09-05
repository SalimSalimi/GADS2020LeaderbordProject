package dz.salim.salimi.gadsleaderbordproject.data.retrofit

import android.telecom.Call
import dz.salim.salimi.gadsleaderbordproject.data.models.Learner
import retrofit2.Response
import retrofit2.http.GET

interface LeadersApiService {

    @GET("/api/hours")
    suspend fun getHoursLeaders(): Response<List<Learner>>
}