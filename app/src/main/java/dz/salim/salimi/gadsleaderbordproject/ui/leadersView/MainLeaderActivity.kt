package dz.salim.salimi.gadsleaderbordproject.ui.leadersView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import dz.salim.salimi.gadsleaderbordproject.R
import dz.salim.salimi.gadsleaderbordproject.ui.formView.FormActivity
import dz.salim.salimi.gadsleaderbordproject.utils.SPLASH_DELAY_TIME
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.*

class MainLeaderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        submit_button_toolbar.setOnClickListener {
            onSubmitToolbarBtnClicked()
        }
        CoroutineScope(Dispatchers.Main).launch {
            delay(SPLASH_DELAY_TIME)
            setupLeaderFragment()
        }
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