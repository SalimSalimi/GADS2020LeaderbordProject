package dz.salim.salimi.gadsleaderbordproject.data

import dz.salim.salimi.gadsleaderbordproject.data.models.Learner
import dz.salim.salimi.gadsleaderbordproject.data.models.Skiller
import dz.salim.salimi.gadsleaderbordproject.data.retrofit.ApiServiceFactory
import retrofit2.Response

object DataRepository {

    suspend fun getHoursLeaders(): Response<List<Learner>> {
        val apiService = ApiServiceFactory.getInstance()
        return apiService.getHoursLeaders()
    }

    suspend fun getSkillLeaders(): Response<List<Skiller>> {
        val apiService = ApiServiceFactory.getInstance()
        return apiService.getSkillIqLeaders()
    }
}