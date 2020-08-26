package com.ht117.ktose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLoad.setOnClickListener {
            tvContent.text = ""
            scope.launch {
                try {
                    val weather = NetworkService.fetchWeather()
                    tvContent.text = weather.toString()
                } catch (exp: Exception) {
                    tvContent.text = exp.message
                }
            }
        }
    }
}
