package ru.mikolaych.androidbasic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import ru.mikolaych.androidbasic1.databinding.ActivityRadioButtonBinding
//Интерфейс RadioGroup.OnCheckedChangeListener
class RadioButton : AppCompatActivity(), RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private lateinit var binding: ActivityRadioButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRadioButtonBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        writePrompt()

        if (binding.button2.isChecked) binding.backButton.visibility = View.INVISIBLE

        binding.backButton.setOnClickListener(this)
        binding.radioGroup.setOnCheckedChangeListener(this)

    }




    override fun onClick(p0: View?) {
        val backToMainActivity = Intent(this, MainActivity::class.java)
        startActivity(backToMainActivity)
    }
//group: RadioGroup? - название радиогруппы, checkedId: Int - id кнопки в группе
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when(checkedId){
            R.id.button1 -> binding.backButton.visibility = View.VISIBLE
            R.id.button2 -> binding.backButton.visibility = View.INVISIBLE
        }
    }

    private fun writePrompt() {
        binding.prompt.text = "//Интерфейс RadioGroup.OnCheckedChangeListener\n" +
                "class RadioButton : AppCompatActivity(), RadioGroup.OnCheckedChangeListener, View.OnClickListener" +
                "//group: RadioGroup? - название радиогруппы, checkedId: Int - id кнопки в группе\n" +
                "    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {\n" +
                "        when(checkedId){\n" +
                "            R.id.button1 -> binding.backButton.visibility = View.VISIBLE\n" +
                "            R.id.button2 -> binding.backButton.visibility = View.INVISIBLE\n" +
                "        }\n" +
                "    }"
    }
}