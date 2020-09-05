package dz.salim.salimi.gadsleaderbordproject.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(manager: FragmentActivity): FragmentStateAdapter(manager) {

    override fun getItemCount(): Int = TAB_NUMBER

    override fun createFragment(position: Int): Fragment {
        val fragment: LeadersFragment = LeadersFragment()
        return fragment
    }

    companion object {
        const val TAB_NUMBER: Int = 2
    }
}