package fi.organization.frb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
/**
 * This is the Main Activity of this application
 *
 * This activity includes button function and connects to Home Activity
 *
 * When clicking the button, Toast message will be executed and users
 * will be directed to the home screen of the app
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * Set button on the log in screen
         * When clicking will print out the given text line
         */
        btnWelcome.setOnClickListener{
            Toast.makeText(this, "Welcome to Food Recipe Book, Let's get started", Toast.LENGTH_LONG).show()

            /**
             * Connect to Home Activity
             */
            var intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}