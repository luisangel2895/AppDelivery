package io.saphi.delivery.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import io.saphi.delivery.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configNav()
    }

    fun configNav(){
        NavigationUI.setupWithNavController(bnvMenu, Navigation.findNavController(this,R.id.fragContent))
    }
}
