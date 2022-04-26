package com.example.customview.customview

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout

class CustomStyledTextInputLayout: TextInputLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)


}