package dz.salim.salimi.gadsleaderbordproject.ui.FormView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import dz.salim.salimi.gadsleaderbordproject.R
import dz.salim.salimi.gadsleaderbordproject.data.DataRepository
import dz.salim.salimi.gadsleaderbordproject.data.models.Form
import kotlinx.android.synthetic.main.fragment_form.*
import kotlinx.android.synthetic.main.leader_list_item.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        submit_button.setOnClickListener {
            onSubmitClickBtn()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun postForm() {
        val email = email_textview.text.toString()
        val name = name_text_view.text.toString()
        val lastName = last_name_textview.text.toString()
        val githubLink = github_textview.text.toString()

        val form = Form(email, name, lastName, githubLink)

        CoroutineScope(Dispatchers.IO).launch {
            val response = DataRepository.postForm(form)
            if (response.isSuccessful) {
                //TODO Implementing the logic
            } else {
                //TODO Implementing the logic
            }
        }
    }

    private fun confirmDialog() {
        val dialogBuilder = AlertDialog.Builder(context!!)
        val dialogLayout: View = LayoutInflater.from(context).inflate(R.layout.custom_confirm_dialog, null)

        dialogBuilder.setView(dialogLayout)

        val alertDialog = dialogBuilder.create()
        alertDialog.show()

    }

    private fun onSubmitClickBtn() {
        confirmDialog()
    }
}