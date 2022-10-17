package ru.mikolaych.androidbasic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.mikolaych.androidbasic1.databinding.ActivityDataExtraBinding

class ActivityDataExtra : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDataExtraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDataExtraBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backButton.text = intent.getStringExtra("textMainButton")
        binding.backButton.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val backToMain = Intent(this, MainActivity::class.java)

        //Отправка данных в активити MainActivity
        backToMain.putExtra("textButton", binding.editTextWindow.text.toString())

        startActivity(backToMain)
    }
}