package com.projects.enzoftware.ankotodo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {

            button("Tap to say hello"){
                onClick { toast("Hello world <3 - Ankito") }
            }

            imageView(R.drawable.anko).
                    lparams(width= matchParent) {
                        padding = dip(20)
                        margin = dip(15)
                    }
        }
    }
}
