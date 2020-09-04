package dz.salim.salimi.gadsleaderbordproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dz.salim.salimi.gadsleaderbordproject.R
import dz.salim.salimi.gadsleaderbordproject.data.models.Leader
import dz.salim.salimi.gadsleaderbordproject.data.models.Learner

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
        linearLayoutManager = LinearLayoutManager(context)
        val listLeaders: ArrayList<Leader> = ArrayList()
        listLeaders.add(Learner("Salim", 5, "Algeria", "URL"))
        listLeaders.add(Learner("Salim", 5, "Algeria", "URL"))
        listLeaders.add(Learner("Salim", 5, "Algeria", "URL"))

        leaderAdapter = LeadersAdapter(listLeaders)

        leadersRecyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = leaderAdapter
        }

        return rootView
    }
}