package edu.temple.dicethrow

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView.Orientation


/*
Our DieThrow application has been refactored to move the dieRoll() logic
into the ViewModel instead of the Fragment.
Study the DieViewModel, ButtonFragment, and DieFragment classes to
see the changes.

Follow the requirements below to have this app function
in both portrait and landscape configurations.
The Activity layout files for both Portrait and Landscape are already provided
*/

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface {

    private lateinit var dieFragment: DieFragment
    private lateinit var buttonFragment: ButtonFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonFragment = ButtonFragment()
        dieFragment = DieFragment()

        val orientation = resources.configuration.orientation

        supportFragmentManager.beginTransaction().apply {
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                replace(R.id.container1, ButtonFragment())
                remove(dieFragment)
            } else {
                replace(R.id.container1, ButtonFragment())
                replace(R.id.container2, dieFragment)
            }
            commit()
        }
    }

    /* TODO 2: switch fragments if portrait (no need to switch fragments if Landscape)
        */
    // Remember to place Fragment transactions on BackStack so then can be reversed
    override fun buttonClicked() {
        val orientation = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container1, dieFragment)
                addToBackStack(null)
                commit()
            }
        }

    }


}