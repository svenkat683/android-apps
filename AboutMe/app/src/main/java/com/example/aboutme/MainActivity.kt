package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var nickNameEdit: EditText
    lateinit var doneButton: Button
    lateinit var nickNameText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nickNameEdit = findViewById(R.id.nickname_edit)
        doneButton = findViewById(R.id.done_button)
        nickNameText = findViewById(R.id.nickname_text)
        doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        nickNameText.text = nickNameEdit.text
        nickNameEdit.visibility = View.GONE
        doneButton.visibility = View.GONE
        nickNameText.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}