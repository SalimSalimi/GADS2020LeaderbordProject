package dz.salim.salimi.gadsleaderbordproject.data

import android.widget.Toast
import dz.salim.salimi.gadsleaderbordproject.data.models.Leader
import dz.salim.salimi.gadsleaderbordproject.data.models.Learner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

object DataRepository {

    suspend fun getHoursLeaders(): Response<List<Learner>>? {
        val apiService = ApiServiceFactory.getInstance()
        return apiService.getHoursLeaders()
    }

}