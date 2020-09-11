package com.hamdy.gadsleaderboard.ui.submit

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamdy.gadsleaderboard.R
import com.hamdy.gadsleaderboard.network.RetrofitInstanceSubmission
import kotlinx.android.synthetic.main.activity_submit.*

class SubmitActivity : AppCompatActivity() {
    private val SUBMIT_URL = "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        SubmitButton.setOnClickListener {
            val response=RetrofitInstanceSubmission.mApi.submitProject(
                SUBMIT_URL,
                firstNameText.text.toString().trim(),
                lastNameText.text.toString().trim(),
                emailText.text.toString().trim(),
                linkGithub.text.toString().trim(),
            )
            val dialog =  Dialog(this)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.setCancelable(true)
            if(response.isSuccessful){
                dialog.setContentView(R.layout.success_dialog)
            }else{
                dialog.setContentView(R.layout.error_dialog)
            }
            dialog.show()

        }
    }
}