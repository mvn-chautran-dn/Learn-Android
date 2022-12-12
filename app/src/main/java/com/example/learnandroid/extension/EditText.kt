package com.example.chauchauproject.extension

import android.text.InputType
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

/**
 *
 */
val EditText.isShow: Boolean
    get() = this.inputType != InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

fun EditText.hide()  {
    this.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
}

fun EditText.show() {
    this.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
}
