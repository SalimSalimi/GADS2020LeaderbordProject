package dz.salim.salimi.gadsleaderbordproject.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import dz.salim.salimi.gadsleaderbordproject.utils.LeaderType

class ViewPagerAdapter(manager: FragmentActivity): FragmentStateAdapter(manager) {

    override fun getItemCount(): Int = TAB_NUMBER

    override fun createFragment(position: Int): Fragment {

        return when(position) {
            0 ->  LeadersFragment(LeaderType.LEADER_HOUR)
            1 ->  LeadersFragment(LeaderType.LEADER_SKILLIQ)
            else ->  LeadersFragment(LeaderType.LEADER_HOUR)
        }
    }

    companion object {
        const val TAB_NUMBER: Int = 2
    }
}