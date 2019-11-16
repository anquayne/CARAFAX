package com.carafax.views.activity

import androidx.appcompat.app.AppCompatActivity
import com.carafax.navigation.Navigator
import javax.inject.Inject

/**
 * class for all the activities throughout the application
 */
abstract class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var navigator : Navigator
}