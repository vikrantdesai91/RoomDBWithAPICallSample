package com.example.roomdbwithapicall.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdbwithapicall.R
import com.example.roomdbwithapicall.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
    }
}