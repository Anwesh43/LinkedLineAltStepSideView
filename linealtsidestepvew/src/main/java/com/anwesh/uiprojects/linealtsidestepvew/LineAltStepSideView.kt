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

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.scaleFactor() : Float = Math.floor(this / scDiv).toFloat()
fun Float.mirrorValue(a : Int, b : Int) : Float = (1 - scaleFactor()) * a.inverse() + scaleFactor() * b.inverse()
fun Float.updateScale(dir : Float, a : Int, b : Int) : Float = mirrorValue(a, b) * dir * scGap

fun Canvas.drawLASNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    val size : Float = gap / sizeFactor
    val hGap : Float = (2 * size) / lines
    val sc1 : Float = scale.divideScale(0, 2)
    val sc2 : Float = scale.divideScale(1, 2)
    paint.strokeCap = strokeCap
    paint.color = strokeColor
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(w/2, gap * (i + 1) - size)
    for (j in 0..(lines - 1)) {
        val scj1 : Float = sc1.divideScale(j, lines)
        val scj2 : Float = sc2.divideScale(j, lines)
        val sf : Float = 1f - 2 * (j % 2)
        save()
        translate((w / 2) * sf * scj2, j * hGap)
        rotate(-90f * sf * scj1)
        drawLine(0f, 0f, 0f, hGap, paint)
        restore()
    }
    restore()
}

class LineAltStepSideView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}