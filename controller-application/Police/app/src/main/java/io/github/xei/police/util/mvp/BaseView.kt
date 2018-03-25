package io.github.xei.police.util.mvp

import android.view.View

/**
 * Created by hamidreza on 3/23/18.
 */
interface BaseView<T> {

    var presenter: T
    val isActive: Boolean

    fun findViews(rootView: View)
    fun setOnClickListeners()
    fun showToast(text: String)
}