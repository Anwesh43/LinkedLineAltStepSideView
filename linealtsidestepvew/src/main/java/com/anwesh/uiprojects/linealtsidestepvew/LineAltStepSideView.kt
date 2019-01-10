package com.anwesh.uiprojects.linealtsidestepvew

/**
 * Created by anweshmishra on 10/01/19.
 */

import android.view.View
import android.view.MotionEvent
import android.content.Context
import android.app.Activity
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Color

val nodes : Int = 5
val lines : Int = 4
val scGap : Float = 0.05f
val scDiv : Double = 0.51
val sizeFactor : Float = 2.7f
val strokeFactor : Float = 90f
val strokeColor : Int = Color.parseColor("#9C27B0")
val backColor : Int = Color.parseColor("#BDBDBD")
val strokeCap : Paint.Cap = Paint.Cap.ROUND