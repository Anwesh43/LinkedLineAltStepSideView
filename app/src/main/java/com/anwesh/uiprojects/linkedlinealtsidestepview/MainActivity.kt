package com.anwesh.uiprojects.linkedlinealtsidestepview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.linealtsidestepvew.LineAltStepSideView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LineAltStepSideView.create(this)
    }
}
