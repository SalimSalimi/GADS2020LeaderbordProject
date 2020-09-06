package dz.salim.salimi.gadsleaderbordproject.data

import dz.salim.salimi.gadsleaderbordproject.data.models.Learner
import dz.salim.salimi.gadsleaderbordproject.data.models.Skiller
import dz.salim.salimi.gadsleaderbordproject.data.retrofit.ApiServiceFactory
import dz.salim.salimi.gadsleaderbordproject.data.retrofit.LeadersApiService
import dz.salim.salimi.gadsleaderbordproject.utils.LEADER_BASE_URL
import retrofit2.Response

object DataRepository {

    suspend fun getHoursLeaders(): Response<List<Learner>> {
        val apiService = ApiServiceFactory.buildService(LEADER_BASE_URL, LeadersApiService::class.java)
        return apiService.getHoursLeaders()
    }

    suspend fun getSkillLeaders(): Response<List<Skiller>> {
        val apiService = ApiServiceFactory.buildService(LEADER_BASE_URL, LeadersApiService::class.java)
        return apiService.getSkillIqLeaders()
    }
}