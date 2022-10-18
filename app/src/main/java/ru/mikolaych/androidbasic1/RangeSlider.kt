package ru.mikolaych.androidbasic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
import ru.mikolaych.androidbasic1.databinding.ActivityRangeSliderBinding

class RangeSlider : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityRangeSliderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRangeSliderBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backButton.setOnClickListener(this)
        writePrompt()

        //Обработка процесса передвигания ползунка
        binding.slider.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
            //В процессе передвигания
            override fun onStartTrackingTouch(slider: RangeSlider) {
                binding.result.text = "Идет выбор"
            }

            //После передвигания
            override fun onStopTrackingTouch(slider: RangeSlider) {
                binding.result.text = "Выбор сделан"
            }

        })

        //Отображение результата выбора слайдера в поле prompt
        binding.slider.addOnChangeListener { rangeSlider, value, fromUser ->
            val values = rangeSlider.values
            val valueFrom = values[0].toString()
            val valueTo = values[1].toString()
            binding.prompt.text = "От $valueFrom до $valueTo"

        }


    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.backButton -> {
                val backToMain = Intent(this, MainActivity::class.java)
                startActivity(backToMain)
            }

        }
    }

    private fun writePrompt() {
        binding.prompt2.text = "" +
                "<com.google.android.material.slider.RangeSlider\n" +
                "        android:id=\"@+id/slider\"\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_marginTop=\"20dp\"\n" +
                "        android:valueFrom=\"0\"\n" +
                "        android:valueTo=\"10\"\n" +
                "        android:stepSize=\"1\"\n" +
                "        app:values=\"@array/slider_value\"\n" +
                "        app:layout_constraintTop_toTopOf=\"parent\"\n" +
                "        app:thumbColor=\"@color/yellow\"\n" +
                "        app:tickColorInactive=\"@color/yellow\"\n" +
                "        app:tickColorActive=\"@color/yellow\"\n" +
                "        app:trackColorActive=\"@color/yellow\"\n" +
                "        app:trackColorInactive=\"@color/purple_700\"/>" +
                "" +
                " //Обработка процесса передвигания ползунка\n" +
                "        binding.slider.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {\n" +
                "            //В процессе передвигания\n" +
                "            override fun onStartTrackingTouch(slider: RangeSlider) {\n" +
                "                binding.result.text = \"Идет выбор\"\n" +
                "            }\n" +
                "\n" +
                "            //После передвигания\n" +
                "            override fun onStopTrackingTouch(slider: RangeSlider) {\n" +
                "                binding.result.text = \"Выбор сделан\"\n" +
                "            }\n" +
                "\n" +
                "        })" +
                "" +
                " //Отображение результата выбора слайдера в поле prompt\n" +
                "        binding.slider.addOnChangeListener { rangeSlider, value, fromUser ->\n" +
                "            val values = rangeSlider.values\n" +
                "            val valueFrom = values[0].toString()\n" +
                "            val valueTo = values[1].toString()\n" +
                "            binding.prompt.text = \"От valueFrom до valueTo\"\n" +
                "\n" +
                "        }"
    }


}
