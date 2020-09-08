package dz.salim.salimi.gadsleaderbordproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import dz.salim.salimi.gadsleaderbordproject.ui.LeadersView.LeadersTabFragment
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupLeaderFragment()

        submit_button_toolbar.setOnClickListener {
            submitBtnClicked()
        }
    }

    private fun setupLeaderFragment() {
        val leadersFragment = LeadersTabFragment()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.main_frame, leadersFragment, "Fragment").commit()
    }

    private fun submitBtnClicked(){
        val intent = Intent(this, FormActivity::class.java)
        startActivity(intent)
    }
}