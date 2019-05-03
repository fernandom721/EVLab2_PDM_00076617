package com.example.evaluacio_parcial_2

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.ContentFrameLayout
import com.example.evaluacio_parcial_2.fragments.Frag_images
import com.example.evaluacio_parcial_2.fragments.Fragment_Buttons

class MainActivity : AppCompatActivity(), Fragment_Buttons.OnSelectOption{
    override fun onAction(id: Int) {

    var content = when(id){
        1 -> {
            Frag_images.newInstance(1)
        }
        2 ->{
            Frag_images.newInstance(2)
        }

        else -> Frag_images.newInstance(3)
    }

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        if(savedInstanceState == null) supportFragmentManager
        .beginTransaction()
        .add(R.layout.fragment_frag_buttons)
        .commit()*/

    }
}
