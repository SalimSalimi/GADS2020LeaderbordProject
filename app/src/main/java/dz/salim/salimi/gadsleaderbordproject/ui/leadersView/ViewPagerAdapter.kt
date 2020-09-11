package dz.salim.salimi.gadsleaderbordproject.ui.leadersView

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import dz.salim.salimi.gadsleaderbordproject.utils.LeaderType
import dz.salim.salimi.gadsleaderbordproject.utils.TAB_NUMBER

class ViewPagerAdapter(manager: Fragment): FragmentStateAdapter(manager) {

    override fun getItemCount(): Int = TAB_NUMBER

    override fun createFragment(position: Int): Fragment {

        return when(position) {
            0 ->  LeadersFragment(LeaderType.LEADER_HOUR)
            1 ->  LeadersFragment(LeaderType.LEADER_SKILLIQ)
            else ->  LeadersFragment(LeaderType.LEADER_HOUR)
        }
    }
}