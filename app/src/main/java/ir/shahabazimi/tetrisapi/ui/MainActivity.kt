package ir.shahabazimi.tetrisapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.shahabazimi.tetrisapi.R
import ir.shahabazimi.tetrisapi.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var b:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.topAppBar.title = getString(R.string.app_name)

    }
}