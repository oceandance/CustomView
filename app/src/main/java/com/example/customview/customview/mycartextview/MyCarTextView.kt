package com.example.customview.customview.mycartextview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.customview.R

class MyCarTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    private val paint = Paint()

    private var isShownView: Boolean = false
    private var figureType: MyCarFigureType = MyCarFigureType.CIRCLE
    private var color: Int = Color.WHITE

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MyCarTextView,
            0, 0
        ).apply {
            try {
                isShownView = getBoolean(R.styleable.MyCarTextView_isShown, false)
                figureType = getFigureType(getInteger(R.styleable.MyCarTextView_typeFigure, 0))

                color = getColor(R.styleable.MyCarTextView_color, Color.WHITE)

                paint.color = color
            } finally {
                recycle()
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        when (figureType) {
            MyCarFigureType.CIRCLE -> drawCircle(canvas)
            MyCarFigureType.RECTANGLE -> drawRectangle(canvas)
        }
        super.onDraw(canvas)
    }

    private fun drawCircle(canvas: Canvas) {
        val width = this.width
        val height = this.height

        val diameter = if (width > height) width else height
        val radius = diameter / 2

        canvas.drawCircle(
            (diameter / 2).toFloat(),
            (diameter / 2).toFloat(),
            radius.toFloat(),
            paint
        )
    }

    private fun drawRectangle(canvas: Canvas) {
        val width = this.width
        val height = this.height

        val rect = Rect(0, 0, width, height)
        canvas.drawRect(rect, paint)
    }

    private fun getFigureType(figureType: Int): MyCarFigureType {
        return when (figureType) {
            0 -> MyCarFigureType.RECTANGLE
            1 -> MyCarFigureType.CIRCLE
            2 -> MyCarFigureType.TRIANGLE
            else -> MyCarFigureType.CIRCLE
        }
    }

}