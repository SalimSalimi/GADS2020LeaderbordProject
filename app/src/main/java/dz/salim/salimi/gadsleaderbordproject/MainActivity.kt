package dz.salim.salimi.gadsleaderbordproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import dz.salim.salimi.gadsleaderbordproject.ui.LeadersView.LeadersTabFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        submit_button_toolbar.setOnClickListener {
            onSubmitToolbarBtnClicked()
        }
        setupLeaderFragment()
    }

    private fun setupLeaderFragment() {
        gads_imageview.visibility = View.GONE
        val leadersFragment = LeadersTabFragment()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.main_frame, leadersFragment, "Fragment").commit()
        toolbar.visibility = View.VISIBLE
    }

    private fun onSubmitToolbarBtnClicked() {
        val intent = Intent(this, FormActivity::class.java)
        startActivity(intent)
    }
}