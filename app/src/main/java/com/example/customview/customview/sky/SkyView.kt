package com.example.customview.customview.sky

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class SkyView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : View(context, attrs) {

    private lateinit var skyPaint: Paint
    private val skyRect: Rect = Rect()

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        skyPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.BLUE
            alpha = 80
            strokeWidth = 2f
            strokeCap = Paint.Cap.ROUND
        }

    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        skyRect.set(left, top, right, bottom/2)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRect(skyRect, skyPaint)
    }

}