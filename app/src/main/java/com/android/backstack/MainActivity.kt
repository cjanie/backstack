package com.android.backstack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var replace: Button
    lateinit var add: Button
    lateinit var bug: Button

    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.text = this.findViewById(R.id.text_view)

        this.replace = this.findViewById(R.id.button_replace)
        this.add = this.findViewById(R.id.button_add)
        this.bug = this.findViewById(R.id.button_bug)


        this.replace.setOnClickListener {
            if(this.supportFragmentManager.backStackEntryCount % 2 == 0) {
                if(this.supportFragmentManager.fragments.isEmpty()) {
                    val redFragment = RedFragment()
                    this.supportFragmentManager.beginTransaction()
                        .replace(R.id.container, redFragment)//.addToBackStack(blueFragment.javaClass.name)
                        .commit()
                    this.text.text = "1st fragment NOT ADDED TO BACKSTACK"
                } else {
                    val blueFragment = BlueFragment()
                    this.supportFragmentManager.beginTransaction()
                        .replace(R.id.container, blueFragment).addToBackStack(blueFragment.javaClass.name)
                        .commit()
                    this.text.text = "fragment added to backstack"
                }

            } else {
                val redFragment = RedFragment()
                this.supportFragmentManager.beginTransaction()
                    .replace(R.id.container, redFragment).addToBackStack(redFragment.javaClass.name)
                    .commit()
                this.text.text = "fragment added to backstack"
            }

        }

        this.add.setOnClickListener {
            if(this.supportFragmentManager.backStackEntryCount % 2 == 0) {
                if(this.supportFragmentManager.fragments.isEmpty()) {
                    val redFragment = RedFragment()
                    this.supportFragmentManager.beginTransaction()
                        .add(R.id.container, redFragment)//.addToBackStack(blueFragment.javaClass.name)
                        .commit()
                    this.text.text = "1st fragment NOT ADDED to backstack => back finishes the activity"

                } else {
                    val blueFragment = BlueFragment()
                    this.supportFragmentManager.beginTransaction()
                        .add(R.id.container, blueFragment).addToBackStack(blueFragment.javaClass.name)
                        .commit()
                    this.text.text = "fragment added to backstack"
                }

            } else {
                val redFragment = RedFragment()
                this.supportFragmentManager.beginTransaction()
                    .add(R.id.container, redFragment).addToBackStack(redFragment.javaClass.name)
                    .commit()
                this.text.text = "fragment added to backstack"
            }
        }

        this.bug.setOnClickListener {
            if(this.supportFragmentManager.backStackEntryCount % 2 == 0) {
                val redFragment = RedFragment()

                this.supportFragmentManager.beginTransaction()
                    .add(R.id.container, redFragment).addToBackStack(redFragment.javaClass.name)
                    .commit()
                this.text.text = "fragment added to backstack"
            } else {
                val blueFragment = BlueFragment()
                this.supportFragmentManager.beginTransaction()
                    .add(R.id.container, blueFragment).addToBackStack(blueFragment.javaClass.name)
                    .commit()
                this.text.text = "fragment added to backstack"
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(this.supportFragmentManager.fragments.isEmpty()) {
            this.text.text = "empty container"
        }
    }

}