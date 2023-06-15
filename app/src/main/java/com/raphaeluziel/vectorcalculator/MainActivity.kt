package com.raphaeluziel.vectorcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raphaeluziel.vectorcalculator.databinding.ActivityMainBinding
import kotlin.math.*

class Vector (var scale: Double = 0.0,  var i: Double = 0.0, var j: Double = 0.0, var k: Double = 0.0) {
    fun magnitude() : Double {
        return sqrt(i*i + j*j + k*k)
    }
    override fun toString(): String {
        return "${i} i + ${j} j + ${k} k +  Magnitude = ${magnitude()}"
    }
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.enterUnitVectorsBtn.setOnClickListener {
            startActivity(Intent(this, EnterUnitVectors::class.java))
        }
    }
}