package dz.salim.salimi.gadsleaderbordproject.ui.LeadersView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dz.salim.salimi.gadsleaderbordproject.R
import dz.salim.salimi.gadsleaderbordproject.data.DataRepository
import dz.salim.salimi.gadsleaderbordproject.data.models.Leader
import dz.salim.salimi.gadsleaderbordproject.data.models.Learner
import dz.salim.salimi.gadsleaderbordproject.utils.LeaderType
import dz.salim.salimi.gadsleaderbordproject.utils.isOnline
import kotlinx.android.synthetic.main.fragment_leaders.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class LeadersFragment(private val leaderType: LeaderType) : Fragment() {

    private lateinit var leadersRecyclerView: RecyclerView
    private var linearLayoutManager: RecyclerView.LayoutManager? = null
    private var leaderAdapter: LeadersAdapter? = null
    private var errorTextView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView: View = inflater.inflate(R.layout.fragment_leaders, container, false)
        leadersRecyclerView = rootView.findViewById(R.id.leaders_list)
        errorTextView = rootView.findViewById(R.id.error_textview)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        when(leaderType) {
            LeaderType.LEADER_HOUR -> getHoursLeaders()
            LeaderType.LEADER_SKILLIQ -> getSkillIqLeaders()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun getHoursLeaders() {
        progressBar.visibility = View.VISIBLE
        if (isOnline(context!!)) {
            CoroutineScope(Dispatchers.IO).launch {
                val response = DataRepository.getHoursLeaders()
                handleResponse(response)
            }
        } else {
            noConnectionError()
        }

    }

    private fun getSkillIqLeaders() {
        progressBar.visibility = View.VISIBLE
        if (isOnline(context!!)) {
            CoroutineScope(Dispatchers.IO).launch {
                val response = DataRepository.getSkillLeaders()
                handleResponse(response)
            }
        } else {
            noConnectionError()
        }
    }

    private fun setupUi(listLeaders: List<Leader>) {
        this.linearLayoutManager = LinearLayoutManager(context)
        this.leaderAdapter = LeadersAdapter(listLeaders)
        this.leadersRecyclerView.apply {
            this.layoutManager = linearLayoutManager
            this.adapter = leaderAdapter
        }
    }

    private suspend fun <T : Leader> handleResponse (response: Response<List<T>>) {
        withContext(Dispatchers.Main) {
            if (response.isSuccessful && response.body() != null) {
                errorTextView!!.visibility = View.INVISIBLE
                progressBar.visibility = View.INVISIBLE
                setupUi(response.body()!!)
            } else {
                progressBar.visibility = View.INVISIBLE
                errorTextView!!.text = response.errorBody().toString()
            }
        }
    }

    private fun noConnectionError() {
        errorTextView!!.apply {
            visibility = View.VISIBLE
            text = getString(R.string.no_internet)
        }
    }
}