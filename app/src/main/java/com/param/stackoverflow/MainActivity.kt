package com.param.stackoverflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.param.stackoverflow.listener.ActionListener

class MainActivity : AppCompatActivity(), ActionListener {

    override fun onAction(action: String) {
        when(action) {
            ACTION_UPDATE_BAR -> invalidateOptionsMenu()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)

        menu?.findItem(R.id.search)?.isVisible = false

        val visibleFragment = supportFragmentManager.getCurrentNavigationFragment()
        visibleFragment?.let {
            if (it is SearchFragment) {
                menu?.findItem((R.id.search))?.isVisible = true
            }
        }

        return super.onCreateOptionsMenu(menu)
    }

    companion object {
        const val ACTION_UPDATE_BAR = "update_action_bar"
    }
}
