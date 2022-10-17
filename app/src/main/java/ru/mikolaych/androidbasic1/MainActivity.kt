package ru.mikolaych.androidbasic1
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
            binding.dataExtraLesson.text = "Первый заход"
        else
            binding.dataExtraLesson.text = "${intent.getStringExtra("textButton")} (уже был тут)"


        binding.fragmentLesson.setOnClickListener(this)
        binding.dataExtraLesson.setOnClickListener(this)
        binding.checkbox.setOnClickListener(this)

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
        }
    }

}