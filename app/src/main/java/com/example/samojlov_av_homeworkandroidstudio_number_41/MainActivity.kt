package com.example.samojlov_av_homeworkandroidstudio_number_41

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.samojlov_av_homeworkandroidstudio_number_4.TimeConvert

@Suppress("IMPLICIT_CAST_TO_ANY")
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var heading1TV: TextView

    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText

    private lateinit var sumButtonBTN: Button
    private lateinit var difButtonBTN: Button

    private lateinit var resultTV: TextView

    private lateinit var resetButtonBTN: Button
    private lateinit var exitButtonBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        heading1TV = findViewById(R.id.heading1TV)
        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)
        sumButtonBTN = findViewById(R.id.sumButtonBTN)
        difButtonBTN = findViewById(R.id.difButtonBTN)
        resultTV = findViewById(R.id.resultTV)
        resetButtonBTN = findViewById(R.id.resetButtonBTN)
        exitButtonBTN = findViewById(R.id.exitButtonBTN)

        sumButtonBTN.setOnClickListener(this)
        difButtonBTN.setOnClickListener(this)
        resetButtonBTN.setOnClickListener(this)
        exitButtonBTN.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {

        var check = true

        if (firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) {
            return
        }

        val first = firstOperandET.text.toString()
        val second = secondOperandET.text.toString()
        val timeConvert = TimeConvert()

        val result = when (v?.id) {
            R.id.sumButtonBTN -> timeConvert.timeStructure(
                timeConvert.timeSecond(first) + timeConvert.timeSecond(
                    second
                )
            )

            R.id.difButtonBTN -> timeConvert.timeStructure(
                timeConvert.timeSecond(first) - timeConvert.timeSecond(
                    second
                )
            )
            R.id.resetButtonBTN -> {
                firstOperandET.text.clear()
                secondOperandET.text.clear()
                check = false
            }
            R.id.exitButtonBTN -> finish()
            else -> "Результат"
        }
        if (!check)resultTV.text = "Результат" else resultTV.text = result.toString()
    }
}