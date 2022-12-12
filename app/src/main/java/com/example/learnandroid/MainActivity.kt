package com.example.learnandroid

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chauchauproject.extension.hide
import com.example.chauchauproject.extension.isShow
import com.example.chauchauproject.extension.show
import com.example.learnandroid.extension.isDefaultEmail
import com.example.learnandroid.extension.isDefaultPassWord
import com.example.learnandroid.extension.isEmailValid
import com.example.learnandroid.extension.isPasswordValid
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    companion object {
        internal const val REGEX_EMAIL = """^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$"""
        internal const val REGEX_PASSWORD = """^[A-Z]+[\w.]{8,16}${'$'}"""
        internal const val DEFAULT_EMAIL = "chauchau@gmail.com"
        internal const val DEFAULT_PASS = "Chau123456"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_login_with.setText(R.string.register_now)
        img_visibility.setOnClickListener {
            if (edt_password.isShow) {
                edt_password.hide()
                edt_password.setSelection(edt_password.text.length)
                img_visibility.setImageResource(R.drawable.ic_visibility)
            } else {
                edt_password.show()
                edt_password.setSelection(edt_password.text.length)
                img_visibility.setImageResource(R.drawable.ic_visibility_off)
            }
        }
        edt_email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (edt_email.text.toString().isEmailValid()) {
                    edt_email.setBackgroundResource(R.drawable.edit_text_enable_background)
                } else {
                    edt_email.setBackgroundResource(R.drawable.edit_text_disable_background)
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        }


        )
        edt_password.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (edt_password.text.toString().isPasswordValid()) {
                        edt_password.setBackgroundResource(R.drawable.edit_text_enable_background)
                    } else {
                        edt_password.setBackgroundResource(R.drawable.edit_text_disable_background)
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                }
            },
        )
        button_next.setOnClickListener {
            if (edt_email.text.toString().isDefaultEmail() && edt_password.text.toString()
                    .isDefaultPassWord()
            ) {
                Toast.makeText(applicationContext,"Dang nhap thanh cong",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext,"Dang nhap that bai",Toast.LENGTH_LONG).show()
            }
        }
    }
}
