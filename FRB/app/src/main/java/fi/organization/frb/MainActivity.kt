package fi.organization.frb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWelcome.setOnClickListener{
            Toast.makeText(this, "Welcome to Food Recipe Book, Let's get started", Toast.LENGTH_LONG).show()
        }
    }
}