package com.csci4020k.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.mariuszgromada.math.mxparser.*
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    private lateinit var display : EditText
    private lateinit var result : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.input)
        display.showSoftInputOnFocus = false //turn off in-device keyboard
        display.setOnClickListener {
            if (getString(R.string.display) == display.text.toString()){
                display.setText("")
            }
        }

    }

    private fun updateText(strToAdd : String){
        var oldString:String = display.text.toString()
        var cursorPos:Int = display.selectionStart
        var leftStr:String = oldString.substring(0, cursorPos)
        var rightStr:String = oldString.substring(cursorPos)
        if (getString(R.string.display) == display.text.toString()){
            display.setText(strToAdd)
            display.setSelection(cursorPos + 1)
        }

        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr))
            display.setSelection(cursorPos + 1)
        }

    }

    fun zeroBtn(view: View) {

        var number = 0

        if (display.text == "0") {

            //do nothing
        }
        else {
            updateText("0")
        }


    }
    fun oneBtn(view: View){
        updateText("1")
    }
    fun twoBtn(view: View){
        updateText("2")
    }
    fun threeBtn(view: View){
        updateText("3")
    }
    fun fourBtn(view: View){
        updateText("4")
    }
    fun fiveBtn(view: View){
        updateText("5")
    }
    fun sixBtn(view: View){
        updateText("6")
    }
    fun sevenBtn(view: View){
        updateText("7")
    }
    fun eightBtn(view: View){
        updateText("8")
    }
    fun nineBtn(view: View){
        updateText("9")
    }
    fun clearBtn(view: View){
        display.setText("")
    }
    fun exponentBtn(view: View){
        updateText("^")
    }
    fun divideBtn(view: View){
        updateText("÷")
    }
    fun multiplyBtn(view: View) {
        updateText("×")
    }
    fun addBtn(view: View){
        updateText("+")
    }
    fun subtractBtn(view: View){
        updateText("-")
    }
    fun plusMinusBtn(view: View){
        updateText("-")
    }
    fun pointBtn(view: View){
        updateText(".")
    }
    fun equalsBtn(view: View){

        var userExp = display.text.toString()
        userExp = userExp.replace(oldValue = "÷", newValue = "/")
        userExp = userExp.replace(oldValue = "×", newValue = "*")
        var exp = Expression(userExp)
        result = exp.calculate().toString()
        display.setText(result)
        display.setSelection(result.length)

    }
    fun backspaceBtn(view: View){
        var cursorPos:Int = display.selectionStart
        var textLen:Int = display.text.length

        if(cursorPos != 0 && textLen != 0){
            display.text = SpannableStringBuilder(display.text).replace(cursorPos - 1, cursorPos, "")
            display.setSelection(cursorPos - 1)
        }

    }
    fun parenthesisBtn(view: View){

    }
}