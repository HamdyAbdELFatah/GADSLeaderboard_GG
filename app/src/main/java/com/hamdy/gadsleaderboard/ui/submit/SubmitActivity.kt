package com.hamdy.gadsleaderboard.ui.submit

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import com.hamdy.gadsleaderboard.R
import com.hamdy.gadsleaderboard.network.RetrofitInstanceSubmission
import kotlinx.android.synthetic.main.activity_submit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmitActivity : AppCompatActivity() {
    private val SUBMIT_URL = "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.confirmation_dialog)
        val window = dialog.window
        window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        window.setGravity(Gravity.CENTER)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        val btnCancel = dialog.findViewById<ImageButton>(R.id.btnCancel)
        val btnSave = dialog.findViewById<Button>(R.id.btnSave)
        SubmitButton.setOnClickListener {
            dialog.show()
            btnCancel.setOnClickListener {dialog.cancel()}
            btnSave.setOnClickListener {
                val dialogStatus =  Dialog(this)
                //dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                dialogStatus.setCancelable(true)
                val response=RetrofitInstanceSubmission.mApi.submitProject(
                    SUBMIT_URL,
                    firstNameText.text.toString().trim(),
                    lastNameText.text.toString().trim(),
                    emailText.text.toString().trim(),
                    linkGithub.text.toString().trim(),
                )

                response.enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        dialogStatus.setContentView(R.layout.success_dialog)
                        dialogStatus.show()
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        dialogStatus.setContentView(R.layout.error_dialog)
                        dialogStatus.show()
                    }

                })
                dialog.cancel()
            }
        }


    }
}