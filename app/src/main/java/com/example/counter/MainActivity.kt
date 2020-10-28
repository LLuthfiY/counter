package com.example.counter

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.

        menuInflater.inflate(R.menu.main, menu)

        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.reset_button -> {
                val dialogBuilder = AlertDialog.Builder(this)

                // set message of alert dialog
                dialogBuilder.setMessage("reset counter ?")
                        // if the dialog is cancelable
                        .setCancelable(false)
                        // positive button text and action
                        .setPositiveButton("Proceed", DialogInterface.OnClickListener { dialog, id ->
                            val text = findViewById<TextView>(R.id.text_home)
                            text.text = "0"

                        })
                        // negative button text and action
                        .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        })

                // create dialog box
                val alert = dialogBuilder.create()
                // set title for alert dialog box
                alert.setTitle("reset counter")
                // show alert dialog
                alert.show()

                true
            }
            R.id.save_button -> {

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
