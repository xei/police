package io.github.xei.police.app

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class Action {

    @SerializedName("p3")
    var p3: Float = 0.toFloat()

    @SerializedName("p5")
    var p5: Float = 0.toFloat()

    @SerializedName("p6")
    var p6: Float = 0.toFloat()

    @SerializedName("p9")
    var p9: Float = 0.toFloat()

    @SerializedName("p10")
    var p10: Float = 0.toFloat()

    @SerializedName("p11")
    var p11: Float = 0.toFloat()

    @SerializedName("d8")
    var d8: Float = 0.toFloat()

    @SerializedName("d12")
    var d12: Float = 0.toFloat()

    @SerializedName("d13")
    var d3: Float = 0.toFloat()

    override fun toString(): String = Gson().toJson(this)

}