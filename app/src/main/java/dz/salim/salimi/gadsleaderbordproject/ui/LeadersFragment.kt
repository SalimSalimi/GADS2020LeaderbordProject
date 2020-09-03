package dz.salim.salimi.gadsleaderbordproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dz.salim.salimi.gadsleaderbordproject.R

class LeadersFragment : Fragment() {

    private lateinit var leadersRecyclerView: RecyclerView

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

        return rootView
    }
}