package dz.salim.salimi.gadsleaderbordproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dz.salim.salimi.gadsleaderbordproject.R
import dz.salim.salimi.gadsleaderbordproject.data.DataRepository
import dz.salim.salimi.gadsleaderbordproject.data.models.Leader
import dz.salim.salimi.gadsleaderbordproject.utils.LeaderType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LeadersFragment(private val leaderType: LeaderType) : Fragment() {

    private lateinit var leadersRecyclerView: RecyclerView
    private var linearLayoutManager: RecyclerView.LayoutManager? = null
    private var leaderAdapter: LeadersAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView: View = inflater.inflate(R.layout.fragment_leaders, container, false)
        leadersRecyclerView = rootView.findViewById(R.id.leaders_list)
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
        CoroutineScope(Dispatchers.IO).launch {
            val response = DataRepository.getHoursLeaders()
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    setupUi(response.body()!!)
                }
            }
        }
    }

    private fun getSkillIqLeaders() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = DataRepository.getSkillLeaders()
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    setupUi(response.body()!!)
                }
            }
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
}