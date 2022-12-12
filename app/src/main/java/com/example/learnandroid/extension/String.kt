package com.example.learnandroid.extension

import com.example.learnandroid.MainActivity

fun String.isPasswordValid(): Boolean {
    return this.matches(MainActivity.REGEX_PASSWORD.toRegex())
}

fun String.isEmailValid(): Boolean {
    return this.matches(MainActivity.REGEX_EMAIL.toRegex())
}

fun String.isDefaultEmail(): Boolean {
    return this == MainActivity.DEFAULT_EMAIL
}

fun String.isDefaultPassWord(): Boolean {
    return this == MainActivity.DEFAULT_PASS
}