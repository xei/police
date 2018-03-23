package io.github.xei.police.util.ext

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by hamidreza on 3/23/18.
 */

fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, @IdRes containerViewId: Int) {
    supportFragmentManager.transact {
        replace(containerViewId, fragment)
    }
}