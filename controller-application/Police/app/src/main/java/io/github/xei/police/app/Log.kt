package io.github.xei.police.app

import android.util.Log

class Log {

    companion object {
        private const val TAG_DEBUG = "POLICE"

        fun i(msg: String) {
            android.util.Log.i("$TAG_DEBUG-I", msg)
        }

        fun e(msg: String) {
            android.util.Log.e("$TAG_DEBUG-E", msg)
        }
    }

}