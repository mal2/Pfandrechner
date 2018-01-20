package com.kbartsch.pfandrechner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.kbartsch.pfandrechner.adapters.PageAdapter

var totalMoney: Float = 0.0f

public class MainActivity : AppCompatActivity() {
    private var mSectionsPagerAdapter: PageAdapter? = null

    /**
     * The [ViewPager] that will host the section contents.
     */
    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = PageAdapter(supportFragmentManager, this)

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById<ViewPager?>(R.id.container)
        mViewPager!!.adapter = mSectionsPagerAdapter

        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)

        // set icons
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_home_24dp)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_info_24dp)

        val TextTotal: TextView = findViewById<TextView>(R.id.TextViewTotalMoney)

        val handler: Handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                // upadte textView here
                val TextTotal: TextView = findViewById<TextView>(R.id.TextViewTotalMoney)
                if (totalMoney == 0.0f) {
                    TextTotal.text = "0.00 €"
                } else {
                    TextTotal.text = "%.2f".format(totalMoney) + " €"
                }
                handler.postDelayed(this, 100) // set time here to refresh textView
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.getItemId()


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}