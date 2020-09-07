package com.jdc.observables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jdc.observables.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding:ActivityMainBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)

        binding.counter = Counter()
    }
}
