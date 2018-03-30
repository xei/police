package io.github.xei.police.joystick

import io.github.xei.police.exception.BluetoothNotSupportException
import io.github.xei.police.util.mvp.BaseModel
import io.github.xei.police.util.mvp.BasePresenter
import io.github.xei.police.util.mvp.BaseView

/**
* Created by hamidreza on 3/23/18.
*/
interface JoystickContract {

    interface Model : BaseModel<Presenter> {

    }

    interface View : BaseView<Presenter> {

        @Throws(BluetoothNotSupportException::class)
        fun isBluetoothEnabled(): Boolean
        fun startBluetoothSettingActivity()
        fun startEnableBluetoothActivityForResult()
        fun connectToHardwareAgent()
    }

    interface Presenter : BasePresenter {
        fun performVoiceCommand(recognizedCommand: String)
    }
}