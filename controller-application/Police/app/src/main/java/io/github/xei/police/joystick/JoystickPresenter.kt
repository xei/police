package io.github.xei.police.joystick

import io.github.xei.police.app.Action
import io.github.xei.police.app.State
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
                    view.connectToHardwareAgent()
                } else {
                    view.startEnableBluetoothActivityForResult()
                }
            } catch (bnse: BluetoothNotSupportException) {
                view.showToast(bnse.message.toString())
            }

        }
    }

    override fun makePolicy(state: State) {
        // TODO: make policy based on the sensors state
        val action = Action()
        sendActionToAgent(action)
    }

    override fun sendActionToAgent(action: Action) {
        if (view.isActive) {
            view.sendActionToAgent(action)
        }
    }

    override fun performVoiceCommand(recognizedCommand: String) {

        when (recognizedCommand) {
            "Go straight" -> sendActionToAgent(Action())
            "Come back" -> sendActionToAgent(Action())
        }

        if (view.isActive) {
            view.showToast(recognizedCommand)
        }
    }

}