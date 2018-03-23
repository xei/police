package io.github.xei.police.joystick

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.github.xei.police.R
import io.github.xei.police.util.ext.replaceFragmentInActivity

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

        initMVP()
    }

    private fun initMVP() {
        val model = JoystickModel()
        val view = supportFragmentManager.findFragmentById(R.id.activityJoystick_frameLayout_fragmentContainer) as JoystickFragment?
                ?: JoystickFragment.newInstance().also {
            replaceFragmentInActivity(it, R.id.activityJoystick_frameLayout_fragmentContainer)
        }
        JoystickPresenter(model, view)
    }

}
