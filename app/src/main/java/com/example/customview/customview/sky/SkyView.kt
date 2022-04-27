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

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        skyPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.BLUE
            alpha = 80
            strokeWidth = 2f
            strokeCap = Paint.Cap.ROUND
        }

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = this.width
        val height = this.height

        val skyRect = Rect(0, 0, width, height)
        canvas.drawRect(skyRect, skyPaint)
    }

}