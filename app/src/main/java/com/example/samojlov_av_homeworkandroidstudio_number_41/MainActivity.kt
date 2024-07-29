package com.example.samojlov_av_homeworkandroidstudio_number_41

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorSpace
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.samojlov_av_homeworkandroidstudio_number_4.TimeConvert
import com.example.samojlov_av_homeworkandroidstudio_number_41.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var toolbarMain: androidx.appcompat.widget.Toolbar

    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText

    private lateinit var sumButtonBTN: Button
    private lateinit var difButtonBTN: Button

    private lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()

        setSupportActionBar(toolbarMain)
        title = getString(R.string.toolbar_title)
        toolbarMain.subtitle = getString(R.string.toolbar_subtitle)
        toolbarMain.setLogo(R.drawable.png_clipart_time_calendar_graphy_computer_icons_time_angle_text)

        sumButtonBTN.setOnClickListener(this)
        difButtonBTN.setOnClickListener(this)
    }

    private fun init() {
        toolbarMain = binding.toolbarMain
        firstOperandET = binding.firstOperandET
        secondOperandET = binding.secondOperandET
        sumButtonBTN = binding.sumButtonBTN
        difButtonBTN = binding.difButtonBTN
        resultTV = binding.resultTV
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("SetTextI18n", "ShowToast")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.resetMenuMain -> {
                firstOperandET.text.clear()
                secondOperandET.text.clear()
                resultTV.text = "Результат"
                Toast.makeText(
                    applicationContext,
                    getString(R.string.toast_reset),
                    Toast.LENGTH_LONG
                ).show()
                resultTV.setTextColor(Color.BLACK)
            }

            R.id.exitMenuMain -> {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.toast_exit),
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onClick(v: View?) {


        if (firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) {
            return
        }

        val first = firstOperandET.text.toString()
        val second = secondOperandET.text.toString()
        val timeConvert = TimeConvert()

        val result = when (v?.id) {
            R.id.sumButtonBTN ->
                timeConvert.timeStructure(
                    timeConvert.timeSecond(first) + timeConvert.timeSecond(
                        second
                    )
                )


            R.id.difButtonBTN ->
                timeConvert.timeStructure(
                    timeConvert.timeSecond(first) - timeConvert.timeSecond(
                        second
                    )
                )

            else -> "Результат"
        }
        if (result == "Результат"){
            return
        }else {
            resultTV.setTextColor(Color.parseColor("#8B0000"))
            Toast.makeText(
                applicationContext,
                "Результат: $result",
                Toast.LENGTH_LONG
            ).show()
        }
        resultTV.text = result
    }
}