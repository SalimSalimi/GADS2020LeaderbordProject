package dz.salim.salimi.gadsleaderbordproject.ui.LeadersView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dz.salim.salimi.gadsleaderbordproject.R
import dz.salim.salimi.gadsleaderbordproject.ui.LeadersView.ViewPagerAdapter

class LeadersTabFragment : Fragment() {

    private lateinit var pagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_leaders_tab, container, false)

        tabLayout = view.findViewById(R.id.tab_layout)
        viewPager = view.findViewById(R.id.pager)

        pagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = "Learning Leaders"
                1 -> tab.text = "Skill IQ Leaders"
            }
        }.attach()

        return view
    }

}