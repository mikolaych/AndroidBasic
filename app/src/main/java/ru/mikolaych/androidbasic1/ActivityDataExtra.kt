package ru.mikolaych.androidbasic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.mikolaych.androidbasic1.databinding.ActivityDataExtraBinding

//Наследование интерфейса View.OnClickListener
class ActivityDataExtra : AppCompatActivity(), View.OnClickListener {
    //Запуск viewBinding
    private lateinit var binding: ActivityDataExtraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDataExtraBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        writePrompt()

        //Запуск функций
        binding.backButton.text = intent.getStringExtra("textMainButton")
        binding.backButton.setOnClickListener(this)


    }
        //Имплементирование метода onClick из интерфейса View.OnClickListener
    override fun onClick(view: View) {
        //Создание интента this - текущее активити, ч/з запятую - активити перехода
        val backToMain = Intent(this, MainActivity::class.java)

        //Отправка данных в активити MainActivity
        backToMain.putExtra("textButton", binding.editTextWindow.text.toString())

        //Запуск активити
        startActivity(backToMain)
    }

    fun writePrompt(){
        binding.prompt.text = " //Создание интента this - текущее активити, ч/з запятую - активити перехода\n" +
                "        val backToMain = Intent(this, MainActivity::class.java)\n" +
                "\n" +
                "        //Отправка данных в активити MainActivity\n" +
                "        backToMain.putExtra(\"textButton\", binding.editTextWindow.text.toString())\n" +
                "\n" +
                "        //Запуск активити\n" +
                "        startActivity(backToMain)" +
                "//Получение данных из ActivityDataExtra\n" +
                "        if (intent.getStringExtra(\"textButton\").isNullOrBlank())\n" +
                "            binding.dataExtraLesson.text = \"Первый заход\"\n" +
                "        else\n" +
                "            binding.dataExtraLesson.text = \"${intent.getStringExtra("textButton")} (уже был тут)\""


    }
}