package ru.mikolaych.androidbasic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.slider.Slider
import ru.mikolaych.androidbasic1.databinding.ActivitySliderBinding
import java.util.*

class Slider : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySliderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySliderBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backButton.setOnClickListener(this)
        writePrompt()



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

        //Отображение результата выбора слайдера в поле prompt
        binding.slider.addOnChangeListener { slider, value, fromUser ->
            binding.prompt.text = value.toString()
        }
    }

    override fun onClick(view: View) {
       when(view.id){
           R.id.backButton -> {
               val backToMain = Intent(this, MainActivity::class.java)
               startActivity(backToMain)
           }

       }
    }

    fun writePrompt(){
        binding.prompt2.text = "<com.google.android.material.slider.Slider\n" +
                "        android:id=\"@+id/slider\"\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_marginTop=\"20dp\"\n" +
                "        android:valueFrom=\"0\"\n" +
                "        android:valueTo=\"5\"\n" +
                "        android:stepSize=\"1\"\n" +
                "        app:layout_constraintTop_toTopOf=\"parent\"\n" +
                "        app:thumbColor=\"@color/yellow\"\n" +
                "        app:tickColorInactive=\"@color/yellow\"\n" +
                "        app:tickColorActive=\"@color/yellow\"\n" +
                "        app:trackColorActive=\"@color/yellow\"\n" +
                "        app:trackColorInactive=\"@color/purple_700\" />" +
                "\n" +
                "\n" +
                "//Обработка процесса передвигания ползунка\n" +
                "        binding.slider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener{\n" +
                "            //В процессе передвигания\n" +
                "            override fun onStartTrackingTouch(slider: Slider) {\n" +
                "                binding.result.text = \"Идет выбор\"\n" +
                "            }\n" +
                "            //После передвигания\n" +
                "            override fun onStopTrackingTouch(slider: Slider) {\n" +
                "                binding.result.text = \"Выбор сделан\"\n" +
                "            }\n" +
                "\n" +
                "        })\n" +
                "\n" +
                "        //Отображение результата выбора слайдера в поле prompt\n" +
                "        binding.slider.addOnChangeListener { slider, value, fromUser ->\n" +
                "            binding.prompt.text = value.toString()\n" +
                "        }"
    }


}


