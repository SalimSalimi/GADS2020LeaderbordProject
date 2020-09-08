package dz.salim.salimi.gadsleaderbordproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import dz.salim.salimi.gadsleaderbordproject.ui.FormView.FormFragment

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        setupFormFragment()
    }

    private fun setupFormFragment() {
        val formFragment = FormFragment()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.form_fragment, formFragment, "Form").commit()
    }
}