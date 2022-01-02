package ir.shahabazimi.tetrisapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.shahabazimi.tetrisapi.R
import ir.shahabazimi.tetrisapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.topAppBar.title = getString(R.string.appbar_title)
    }
}