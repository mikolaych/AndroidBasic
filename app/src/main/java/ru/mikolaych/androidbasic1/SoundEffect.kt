package ru.mikolaych.androidbasic1

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.mikolaych.androidbasic1.databinding.SoundEffectBinding

class SoundEffect : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:SoundEffectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = SoundEffectBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




        binding.backToMain.setOnClickListener(this)
        binding.soundOn.setOnClickListener(this)
        binding.soundOff.setOnClickListener(this)

    }

    private fun rainSoundActivate(activate:Boolean){
        var music = MediaPlayer.create(this, R.raw.rain)
        if (activate && !music.isPlaying)
                music.start()


        else if (!activate && music.isPlaying) {
            music.stop()
            music.reset()
            music.release()
            music = null
        }
    }



    override fun onClick(view: View) {
        when(view.id){
            R.id.backToMain -> {
                val backToMain = Intent(this, MainActivity::class.java)
                startActivity(backToMain)
            }
            R.id.soundOn -> rainSoundActivate(activate = true)
            R.id.soundOff -> rainSoundActivate(activate = false)
        }

    }

    override fun onPause() {
        super.onPause()
        rainSoundActivate(activate = false)
    }
}