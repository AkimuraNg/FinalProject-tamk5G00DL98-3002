package fi.organization.frb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //set button to show text and move to Home Screen activity
        btnWelcome.setOnClickListener{
            Toast.makeText(this, "Welcome to Food Recipe Book, Let's get started", Toast.LENGTH_LONG).show()

            var intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}