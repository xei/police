package io.github.xei.police.joystick

import io.github.xei.police.exception.BluetoothNotSupportException

/**
 * Created by hamidreza on 3/23/18.
 */
class JoystickPresenter(private val model: JoystickContract.Model, private val view: JoystickContract.View) : JoystickContract.Presenter {

    init {
        model.presenter = this
        view.presenter = this
    }

    override fun start() {
        if (view.isActive) {
            try {
                if (view.isBluetoothEnabled()) {
                    // TODO: connect to device
                } else {
                    view.startEnableBluetoothActivityForResult()
                }
            } catch (bnse: BluetoothNotSupportException) {
                view.showToast(bnse.message.toString())
            }

        }
    }

    override fun performVoiceCommand(recognizedCommand: String) {
        if (view.isActive) {
            view.showToast(recognizedCommand)
        }
    }

}