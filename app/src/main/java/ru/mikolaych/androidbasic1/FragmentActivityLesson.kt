package ru.mikolaych.androidbasic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.mikolaych.androidbasic1.R
import ru.mikolaych.androidbasic1.databinding.ActivityFragmentLessonBinding

class FragmentActivityLesson : AppCompatActivity() {
    private lateinit var binding:ActivityFragmentLessonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFragmentLessonBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Вызов фрагмента FirstFragment в поле fragmentWindow
        binding.startFragmentButton.setOnClickListener(View.OnClickListener {
            supportFragmentManager.beginTransaction().add(R.id.fragmentWindow, FirstFragment()).commit()
        })

        //Переход на MainActivity
        binding.backToMain.setOnClickListener(View.OnClickListener {
            val backToMain = Intent(this, MainActivity::class.java)
            startActivity(backToMain)


        })
    }


}