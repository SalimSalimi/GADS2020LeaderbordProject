package dz.salim.salimi.gadsleaderbordproject.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dz.salim.salimi.gadsleaderbordproject.R
import dz.salim.salimi.gadsleaderbordproject.data.DataRepository
import dz.salim.salimi.gadsleaderbordproject.data.models.Leader
import dz.salim.salimi.gadsleaderbordproject.data.models.Learner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class LeadersFragment : Fragment() {

    private lateinit var leadersRecyclerView: RecyclerView
    private var linearLayoutManager: RecyclerView.LayoutManager? = null
    private var leaderAdapter: LeadersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_leaders, container, false)

        leadersRecyclerView = rootView.findViewById<RecyclerView>(R.id.leaders_list)

        //leaderAdapter = LeadersAdapter(listLeaders)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        getSkillIqLeaders()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupUi(adapter: LeadersAdapter) {
        linearLayoutManager = LinearLayoutManager(context)
        leadersRecyclerView.apply {
            this.layoutManager = linearLayoutManager
            this.adapter = adapter
        }
    }

    private fun getHoursLeaders() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = DataRepository.getHoursLeaders()
            if (response.isSuccessful) {
                response.let {
                    val adapter: LeadersAdapter = LeadersAdapter(it.body()!!)
                    withContext(Dispatchers.Main) {
                        setupUi(adapter)
                    }
                }
            }
        }
    }

    private fun getSkillIqLeaders() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = DataRepository.getSkillLeaders()
            if (response.isSuccessful) {
                response.let {
                    val adapter: LeadersAdapter = LeadersAdapter(it.body()!!)
                    withContext(Dispatchers.Main) {
                        setupUi(adapter)
                    }
                }
            }
        }
    }
}