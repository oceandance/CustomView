package com.example.customview.customview.mycartextview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.customview.R

class MyCarTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    private var isShownView: Boolean = false
    private var figureType: MyCarFigureType = MyCarFigureType.CIRCLE

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MyCarTextView,
            0, 0
        ).apply {
            try {
                isShownView = getBoolean(R.styleable.MyCarTextView_isShown, false)
                figureType = getFigureType(getInteger(R.styleable.MyCarTextView_typeFigure, 0))
            } finally {
                recycle()
            }
        }
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