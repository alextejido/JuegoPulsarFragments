package com.example.alex.juegopulsar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_one.*

class MainActivity : AppCompatActivity() {

    var contador = 0;
    var isFragmentOneLoaded = true
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ShowFragmentOne()
        //val listView = findViewById<Button>(R.id.sumar)
        //listView.setEnabled(false)

        empezar.setOnClickListener ({
            object : CountDownTimer(10000, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                    //segundos.setText("" + millisUntilFinished / 1000)

                }

                override fun onFinish() {
                    //segundos.setText("done!")
                    if (isFragmentOneLoaded)
                        ShowFragmentTwo()
                    else
                        ShowFragmentOne()
                    //sumar.setEnabled(false)

                }

            }.start()
            //empezar.setEnabled(false)
           // sumar.setEnabled(true)

        })
        /*sumar.setOnClickListener {
            contador = contador + 1

        }


       empezar.setOnClickListener({
            if (isFragmentOneLoaded)
                ShowFragmentTwo()
            else
                ShowFragmentOne()
        })*/
    }

    fun ShowFragmentOne() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true
    }

    fun ShowFragmentTwo() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false
    }
}
