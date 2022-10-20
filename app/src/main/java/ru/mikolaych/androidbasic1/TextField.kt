package ru.mikolaych.androidbasic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import ru.mikolaych.androidbasic1.databinding.ActivityTextFieldBinding

class TextField : AppCompatActivity(), View.OnKeyListener, View.OnClickListener {
    private lateinit var  binding:ActivityTextFieldBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTextFieldBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.textView.setOnKeyListener(this)
        binding.backButton.setOnClickListener(this)
    }

    override fun onKey(view: View, keyCode: Int, event: KeyEvent): Boolean {
        when(view.id){
            R.id.textView -> {
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                    binding.result.text = binding.textView.text
                    binding.textView.setText("")
                    return true
                }

            }

        }
        return false
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.backButton -> {
                val startBack = Intent(this, MainActivity::class.java)
                startActivity(startBack)
            }
        }
    }


}