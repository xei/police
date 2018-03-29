package io.github.xei.police.joystick


import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast

import io.github.xei.police.R
import io.github.xei.police.exception.BluetoothNotSupportException


/**
 * A simple [Fragment] subclass.
 * Use the [JoystickFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class JoystickFragment : Fragment(), JoystickContract.View, View.OnClickListener {

    companion object {
        private const val REQUEST_CODE_ENABLE_BLUETOOTH = 100
        private const val REQUEST_CODE_SPEECH_RECOGNIZE = 200

        fun newInstance() = JoystickFragment()
    }

    override lateinit var presenter: JoystickContract.Presenter
    override val isActive: Boolean
        get() = isAdded

    private lateinit var mUpArrowKeyImageButton: ImageButton
    private lateinit var mVoiceCommandImageButton: ImageButton


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView =  inflater.inflate(R.layout.fragment_joystick, container, false)

        findViews(rootView)
        setOnClickListeners()

        presenter.start()

        return rootView
    }

    override fun findViews(rootView: View) {
        mUpArrowKeyImageButton = rootView.findViewById(R.id.fragmentJoystick_imageButton_upArrowButton)
        mVoiceCommandImageButton = rootView.findViewById(R.id.layoutFragmentJoystickCenter_imageButton_voiceCommand)
    }

    override fun setOnClickListeners() {
        mUpArrowKeyImageButton.setOnClickListener(this)
        mVoiceCommandImageButton.setOnClickListener(this)
    }

    override fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    override fun isBluetoothEnabled(): Boolean {
        try {
            return BluetoothAdapter.getDefaultAdapter()!!.isEnabled
        } catch (npe: NullPointerException) {
            throw BluetoothNotSupportException()
        }
    }

    override fun startEnableBluetoothActivityForResult() {
        val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        startActivityForResult(intent, REQUEST_CODE_ENABLE_BLUETOOTH)
    }

    private fun startVoiceRecognitionActivityForResult() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, javaClass.`package`.name)
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, resources.getString(R.string.prompt_voiceCommand_dialog))
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1)
//        val speechLanguage = "fa-IR"
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, speechLanguage)
        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_RECOGNIZE)
        } catch (anfe: ActivityNotFoundException) {
            Toast.makeText(context, "Voice command not supported", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onClick(clickedView: View?) {
        when(clickedView?.id) {
            R.id.layoutFragmentJoystickCenter_imageButton_voiceCommand -> startVoiceRecognitionActivityForResult()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {

            REQUEST_CODE_ENABLE_BLUETOOTH -> if (resultCode == Activity.RESULT_OK) {
                // TODO: connect to device
                // TODO: change LED to green
            }

            REQUEST_CODE_SPEECH_RECOGNIZE -> if (resultCode == Activity.RESULT_OK && data != null) {
                val recognizedCommand = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                presenter.performVoiceCommand(recognizedCommand[0])
            }
        }

    }

}