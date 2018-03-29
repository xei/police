package io.github.xei.police.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.github.xei.police.R
import io.github.xei.police.joystick.JoystickActivity

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        // TODO: temporarily open the Joystick activity
        JoystickActivity.start(this)
    }
}
