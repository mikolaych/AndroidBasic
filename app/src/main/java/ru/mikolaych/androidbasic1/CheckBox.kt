package ru.mikolaych.androidbasic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import ru.mikolaych.androidbasic1.databinding.ActivityCheckBoxBinding

var status = false
//интерфейсы на OnClickListener и OnCheckedChangeListener
class CheckBox : AppCompatActivity(), View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private lateinit var binding:ActivityCheckBoxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCheckBoxBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        writePrompt()

        if (!binding.checkbox.isChecked) binding.backButton.visibility = View.INVISIBLE

        binding.backButton.setOnClickListener(this)
        binding.checkbox.setOnCheckedChangeListener(this)


    }




    override fun onClick(v: View) {
        when(v.id){
            R.id.backButton ->{
               val backToMain = Intent(this, MainActivity::class.java)
                startActivity(backToMain)
            }

            }

        }

    //Обработка Чекбокса
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if (isChecked) binding.backButton.visibility = View.VISIBLE
        else binding.backButton.visibility = View.INVISIBLE
    }

    private fun writePrompt() {
        binding.prompt.text = "//Обработка Чекбокса\n" +
                "    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {\n" +
                "        if (isChecked) binding.backButton.visibility = View.VISIBLE\n" +
                "        else binding.backButton.visibility = View.INVISIBLE\n" +
                "    }//интерфейсы на OnClickListener и OnCheckedChangeListener\n" +
                "class CheckBox : AppCompatActivity(), View.OnClickListener, CompoundButton.OnCheckedChangeListener" +
                ""
    }

}




