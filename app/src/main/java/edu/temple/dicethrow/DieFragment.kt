package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    private lateinit var dieTextView: TextView
    private var dieSides: Int = 6  // default value

    companion object {
        private const val ARG_SIDES = "sidenumber"

        // Factory Method to create a DieFragment with custom sides
        fun newInstance(sides: Int = 6): DieFragment {
            val fragment = DieFragment()
            val args = Bundle()
            args.putInt(ARG_SIDES, sides)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Safely get the number of sides from arguments
        arguments?.let {
            dieSides = it.getInt(ARG_SIDES, 6)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        throwDie()  //
        view.setOnClickListener {
            throwDie()  //
        }
    }

    // Public method to throw the die
    fun throwDie() {
        dieTextView.text = Random.nextInt(1, dieSides + 1).toString()
    }
}