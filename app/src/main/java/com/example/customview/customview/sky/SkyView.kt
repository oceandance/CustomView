package com.example.customview.customview.sky

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Point
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import java.util.*

class SkyView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : View(context, attrs) {

    private var skyPaint: Paint
    private var moonPaint: Paint
    private var starPaint: Paint

    private val skyRect: Rect = Rect()

    private val starsPath: Path = Path()

    init {
        skyPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.BLUE
            alpha = 80
            strokeWidth = 2f
            strokeCap = Paint.Cap.ROUND
        }

        moonPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.YELLOW
            style = Paint.Style.FILL
        }

        starPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.YELLOW
            style = Paint.Style.FILL
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        skyRect.set(left, top, right, bottom/2)
        drawStarsPath()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRect(skyRect, skyPaint)
        canvas.drawCircle(800f, 250f, 50f, moonPaint)
        canvas.drawPath(starsPath, starPaint)
    }

    private fun drawStarsPath() {
        starsPath.fillType = Path.FillType.WINDING
        for (i in 0..10) {
            val starPixel = getRandomNumber(3, 10)
            val starDiameter = starPixel * 6

            val startX = getRandomNumber(0, width - starDiameter)
            val startY = getRandomNumber(0, height / 2 - starDiameter)

            val a = Point(startX, startY)
            val b = Point(startX + starPixel * 2, startY + starPixel * 6)
            val c = Point(startX - starPixel * 3, startY + starPixel * 2)
            val d = Point(startX + starPixel * 3, startY + starPixel * 2)
            val e = Point(startX - starPixel * 2, startY + starPixel * 6)

            starsPath.moveTo(a.x.toFloat(), a.y.toFloat())
            starsPath.lineTo(b.x.toFloat(), b.y.toFloat())
            starsPath.lineTo(c.x.toFloat(), c.y.toFloat())
            starsPath.lineTo(d.x.toFloat(), d.y.toFloat())
            starsPath.lineTo(e.x.toFloat(), e.y.toFloat())
            starsPath.lineTo(a.x.toFloat(), a.y.toFloat())
        }
    }

    private fun getRandomNumber(min: Int, max: Int): Int {
        return Random().nextInt(max - min + 1) + min
    }
}