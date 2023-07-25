package com.example.notecounter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var numberView: TextView
    private lateinit var text500: TextView
    private lateinit var text100: TextView
    private lateinit var text50: TextView
    private lateinit var text20: TextView
    private lateinit var text10: TextView
    private lateinit var text5: TextView
    private lateinit var text1: TextView

    private var expression = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title = "Vangti Chai!"
        numberView = findViewById(R.id.numText)
        text500 = findViewById(R.id.text500)
        text100 = findViewById(R.id.text100)
        text50 = findViewById(R.id.text50)
        text20 = findViewById(R.id.text20)
        text10 = findViewById(R.id.text10)
        text5 = findViewById(R.id.text5)
        text1 = findViewById(R.id.text1)

        if (savedInstanceState != null) {
            with(savedInstanceState) {
                Log.d(TAG, "onCreate: ${getString(KEY_EXP)}")
                numberView.text = getString(KEY_EXP)
                text500.text = getString(KEY_500)
                text100.text = getString(KEY_100)
                text50.text = getString(KEY_50)
                text20.text = getString(KEY_20)
                text10.text = getString(KEY_10)
                text5.text = getString(KEY_5)
                text1.text = getString(KEY_1)

            }
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState: Called")
        savedInstanceState.run {
            numberView.text = getString(KEY_EXP)
            text500.text = getString(KEY_500)
            text100.text = getString(KEY_100)
            text50.text = getString(KEY_50)
            text20.text = getString(KEY_20)
            text10.text = getString(KEY_10)
            text5.text = getString(KEY_5)
            text1.text = getString(KEY_1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState: called")
        outState.run {
            Log.d(TAG, "onSaveInstanceState: called")
            putString(KEY_1, text1.text.toString())
            putString(KEY_5, text5.text.toString())
            putString(KEY_100, text100.text.toString())
            putString(KEY_50, text50.text.toString())
            putString(KEY_500, text500.text.toString())
            putString(KEY_20, text20.text.toString())
            putString(KEY_EXP, numberView.text.toString())
            putString(KEY_10, text10.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    @SuppressLint("SetTextI18n")
    fun onClick(view: View) {
        val button = view as Button

        Log.d(Companion.TAG, "onClick: ${button.text}")
        expression += button.text
        numberView.text = expression
        countNotes(numberView.text.toString())
    }

    @SuppressLint("SetTextI18n")
    fun countNotes(text: String) {
        var remain = text.toInt()
        var num = remain / 500
        text500.text = "500: $num"
        remain -= (num * 500)
        num = remain / 100
        text100.text = "100: $num"
        remain -= (num * 100)
        num = remain / 50
        text50.text = "50: $num"
        remain -= num * 50
        num = remain / 20
        text20.text = "20: $num"
        remain -= num * 20
        num = remain / 10
        text10.text = "10: $num"
        remain -= num * 10
        num = remain / 5
        text5.text = "5: $num"
        remain -= num * 5
        num = remain / 1
        text1.text = "1: $num"
        remain -= num * 1
    }

    @SuppressLint("SetTextI18n")
    fun onClear(view: View) {
        numberView.text = ""
        text500.text = "500:"
        text100.text = "100:"
        text50.text = "50:"
        text20.text = "20:"
        text10.text = "10:"
        text5.text = "5:"
        text1.text = "1:"
        expression = ""
    }

    companion object {
        private const val TAG = "MainActivity"
        private const val KEY_EXP = "exp_key"
        private const val KEY_500 = "500_key"
        private const val KEY_100 = "100_key"
        private const val KEY_50 = "50_key"
        private const val KEY_20 = "20_key"
        private const val KEY_10 = "10_key"
        private const val KEY_5 = "5_key"
        private const val KEY_1 = "1_key"
    }
}