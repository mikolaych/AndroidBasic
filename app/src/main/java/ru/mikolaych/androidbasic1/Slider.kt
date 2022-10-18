package ru.mikolaych.androidbasic1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.slider.Slider
import ru.mikolaych.androidbasic1.databinding.ActivitySliderBinding
import java.util.*

class Slider : AppCompatActivity() {
    private lateinit var binding: ActivitySliderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySliderBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        //Обработка процесса передвигания ползунка
        binding.slider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener{
            //В процессе передвигания
            override fun onStartTrackingTouch(slider: Slider) {
                binding.result.text = "Идет выбор"
            }
            //После передвигания
            override fun onStopTrackingTouch(slider: Slider) {
                binding.result.text = "Выбор сделан"
            }

        })

        binding.slider.addOnChangeListener { slider, value, fromUser ->
            binding.prompt.text = value.toString()
        }
    }


}


