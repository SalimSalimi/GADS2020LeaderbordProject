package dz.salim.salimi.gadsleaderbordproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import dz.salim.salimi.gadsleaderbordproject.ui.FormView.FormFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val leadersFragment = FormFragment()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.main_frame, leadersFragment, "Fragment").commit()
    }
}