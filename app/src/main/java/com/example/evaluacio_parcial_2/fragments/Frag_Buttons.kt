package com.example.evaluacio_parcial_2.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.evaluacio_parcial_2.R
import kotlinx.android.synthetic.main.fragment_frag_buttons.view.*

val PREV: String = "prev"
val NEXT: String = "next"


class Fragment_Buttons : Fragment() {

    var listener: OnSelectOption? = null

    var action1: String? = null
    var action2: String? = null



    companion object {

        fun newInstace(action1: String, action2: String) =
            Fragment_Buttons().apply {
                arguments  = Bundle().apply {
                    putString(PREV,action1)
                    putString(NEXT,action2)

                }
            }
    }

    interface OnSelectOption {
        fun onAction(id: Int)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnSelectOption) {
            listener = context
        } else {
            throw RuntimeException("Se necesita una implementación de  OnSelectOption")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            action1 = getString(PREV)
            action2 = getString(NEXT)

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?) =
        inflater.inflate(
            R.layout.fragment_frag_buttons,
            container, false).apply {
            prev_btn.apply {
                text = action1
                setOnClickListener {
                    listener?.onAction(1)
                }
            }
            next_img.apply {
                text = action2
                setOnClickListener {
                    listener?.onAction(2)
                }
            }

        }


    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}