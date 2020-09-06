package dz.salim.salimi.gadsleaderbordproject.data

import dz.salim.salimi.gadsleaderbordproject.data.models.Form
import dz.salim.salimi.gadsleaderbordproject.data.models.Learner
import dz.salim.salimi.gadsleaderbordproject.data.models.Skiller
import dz.salim.salimi.gadsleaderbordproject.data.retrofit.ApiServiceFactory
import dz.salim.salimi.gadsleaderbordproject.data.retrofit.FormApiService
import dz.salim.salimi.gadsleaderbordproject.data.retrofit.LeadersApiService
import dz.salim.salimi.gadsleaderbordproject.utils.FORM_BASE_URL
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

    suspend fun postForm(form: Form): Response<Void> {
        val apiService = ApiServiceFactory.buildService(FORM_BASE_URL, FormApiService::class.java)
        return apiService.submitForm(form.email, form.name, form.lastName, form.githubLink)
    }
}