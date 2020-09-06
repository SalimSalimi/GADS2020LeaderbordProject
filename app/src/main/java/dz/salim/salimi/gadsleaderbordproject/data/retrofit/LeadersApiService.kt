package dz.salim.salimi.gadsleaderbordproject.data.retrofit

import dz.salim.salimi.gadsleaderbordproject.data.models.Learner
import dz.salim.salimi.gadsleaderbordproject.data.models.Skiller
import retrofit2.Response
import retrofit2.http.GET
import dz.salim.salimi.gadsleaderbordproject.utils.HOURS_LEADERS_ENDPOINTS
import dz.salim.salimi.gadsleaderbordproject.utils.SKILLIQ_LEADERS_ENDPOINTS

interface LeadersApiService {

    @GET(HOURS_LEADERS_ENDPOINTS)
    suspend fun getHoursLeaders(): Response<List<Learner>>

    @GET(SKILLIQ_LEADERS_ENDPOINTS)
    suspend fun getSkillIqLeaders(): Response<List<Skiller>>
}