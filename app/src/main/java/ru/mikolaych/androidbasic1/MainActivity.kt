package ru.mikolaych.androidbasic1
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.mikolaych.androidbasic1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//Получение данных из ActivityDataExtra
        if (intent.getStringExtra("textButton").isNullOrBlank())
            binding.dataExtraLesson.text = "Прием/передача данных из активити"
        else
            binding.dataExtraLesson.text = "${intent.getStringExtra("textButton")} (уже был тут)"


        binding.fragmentLesson.setOnClickListener(this)
        binding.dataExtraLesson.setOnClickListener(this)
        binding.checkbox.setOnClickListener(this)
        binding.radiobutton.setOnClickListener(this)
        binding.slider.setOnClickListener(this)
        binding.rangeSlider.setOnClickListener(this)



    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.fragmentLesson -> {
                val startLessonActivity = Intent(this, FragmentActivityLesson::class.java)
                startActivity(startLessonActivity)
            }
            R.id.dataExtraLesson -> {
                val startActivityData = Intent(this, ActivityDataExtra::class.java)

                //Отправка текста в ActivityDataExtra
                startActivityData.putExtra("textMainButton", "Я из MainActivity")

                startActivity(startActivityData)
            }
            R.id.checkbox -> {
                val startCheckbox = Intent(this, CheckBox::class.java)
                startActivity(startCheckbox)
            }

            R.id.radiobutton -> {
                val startRButton = Intent(this, RadioButton::class.java)
                startActivity(startRButton)
            }
            R.id.slider -> {
                val startSlider = Intent(this, Slider::class.java)
                startActivity(startSlider)
            }

            R.id.rangeSlider -> {
                val startRangeSlider = Intent(this, RangeSlider::class.java)
                startActivity(startRangeSlider)
            }
        }
    }



}