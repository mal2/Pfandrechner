package com.kbartsch.pfandrechner.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kbartsch.pfandrechner.R


class InfoFragment() : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.info_main, container, false)
        return rootView
    }

    companion object {

        fun newInstance(): InfoFragment {
            val fragment = InfoFragment()
            return fragment
        }
    }
}