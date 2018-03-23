package io.github.xei.police.joystick


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.github.xei.police.R


/**
 * A simple [Fragment] subclass.
 * Use the [JoystickFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class JoystickFragment : Fragment(), JoystickContract.View {

    companion object {
        fun newInstance() = JoystickFragment()
    }

    override lateinit var presenter: JoystickContract.Presenter
    override val isActive: Boolean
        get() = isAdded

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_joystick, container, false)
    }

    override fun findViews(rootView: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setOnClickListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}