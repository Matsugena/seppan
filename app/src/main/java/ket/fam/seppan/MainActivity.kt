package ket.fam.seppan

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,BottomNavigationView.OnNavigationItemSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //loading the default fragment
        loadFragment(HomeFragment())

        //getting bottom navigation view and attaching the listener
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(this)

    }
    override fun onNavigationItemSelected (item: MenuItem): Boolean{
        var fragment: Fragment? = null

        when (item.getItemId()) {
            R.id.navigation_home -> {
                fragment = HomeFragment()
                message.text = resources.getString(R.string.title_home)
            }
            R.id.navigation_list -> {
                fragment = ListFragment()
                message.text = resources.getString(R.string.title_list)
            }
            R.id.navigation_settings -> {
                fragment = SettingFragment()
                message.text = resources.getString(R.string.title_settings)
            }
        }
        return loadFragment(fragment)
    }
    private fun loadFragment(fragment: Fragment?): Boolean{
        if(fragment != null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.MainContainer, fragment)
                .commit()
            return true
        }
        return false
    }
}
