package ru.mikolaych.androidbasic1

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import ru.mikolaych.androidbasic1.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding:FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        //Закрытие фрагмента(удалениеиз фрагментмнеджера)
        binding.backButton.setOnClickListener(View.OnClickListener {
            (context as FragmentActivity).supportFragmentManager.beginTransaction().remove(this).commit()
        })

        writePrompt()


        return binding.root
    }

    private fun writePrompt() {
        binding.prompt.text = " //Вызов фрагмента FirstFragment в поле fragmentWindow\n" +
                "        binding.startFragmentButton.setOnClickListener(View.OnClickListener {\n" +
                "            supportFragmentManager.beginTransaction().add(R.id.fragmentWindow, FirstFragment()).commit()\n" +
                "        })" +
                " //Закрытие фрагмента(удалениеиз фрагментмнеджера)\n" +
                "        binding.backButton.setOnClickListener(View.OnClickListener {\n" +
                "            (context as FragmentActivity).supportFragmentManager.beginTransaction().remove(this).commit()\n" +
                "        })"
    }


}