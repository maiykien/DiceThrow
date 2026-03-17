package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var dieFragment: DieFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.rollDiceButton)

        // Create fragment
         dieFragment = DieFragment().apply {
            arguments = Bundle().apply {
                putInt("sidenumber", 6)
            }
        }

        // Add fragment to screen
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, dieFragment)
            .commit()

        // Button click → roll dice
        rollButton.setOnClickListener {
            dieFragment.throwDie()
        }




    }
}

