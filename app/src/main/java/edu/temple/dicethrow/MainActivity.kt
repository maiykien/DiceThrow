package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dieFragment1: DieFragment
    private lateinit var dieFragment2: DieFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.rollDiceButton)

        // ✅ Create first die (6 sides)
        dieFragment1 = DieFragment.newInstance(6)

        // ✅ Create second die (6 sides, could be any number)
        dieFragment2 = DieFragment.newInstance(6)

        // ✅ Add fragments to screen
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView1, dieFragment1)
            .replace(R.id.fragmentContainerView2, dieFragment2)
            .commit()

        // ✅ Button click → roll both dice
        rollButton.setOnClickListener {
            dieFragment1.throwDie()
            dieFragment2.throwDie()
        }
    }
}