package ru.mikolaych.androidbasic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import ru.mikolaych.androidbasic1.databinding.ActivityCheckBoxBinding

var status = false
class CheckBox : AppCompatActivity(), View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private lateinit var binding:ActivityCheckBoxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCheckBoxBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backButton.setOnClickListener(this)
        binding.statusButton.setOnClickListener(this)
        binding.checkbox.setOnCheckedChangeListener(this)


    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.backButton ->{
               val backToMain = Intent(this, MainActivity::class.java)
                startActivity(backToMain)
            }
            R.id.statusButton ->{
                if (status) binding.backButton.visibility = View.VISIBLE
                else binding.backButton.visibility = View.INVISIBLE
            }

            }

        }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        status = isChecked
    }

}




