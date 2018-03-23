package io.github.xei.police.joystick

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.github.xei.police.R

class JoystickActivity : AppCompatActivity() {

    companion object {
        fun start(invokerContext: Context) {
            val startIntent = Intent(invokerContext, JoystickActivity::class.java)
            invokerContext.startActivity(startIntent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joystick)
    }
}
