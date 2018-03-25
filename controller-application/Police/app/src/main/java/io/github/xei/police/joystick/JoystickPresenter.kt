package io.github.xei.police.joystick

/**
 * Created by hamidreza on 3/23/18.
 */
class JoystickPresenter(private val model: JoystickContract.Model, private val view: JoystickContract.View) : JoystickContract.Presenter {

    init {
        model.presenter = this
        view.presenter = this
    }

    override fun start() {

    }

    override fun performVoiceCommand(recognizedCommand: String) {
        if (view.isActive) {
            view.showToast(recognizedCommand)
        }
    }

}