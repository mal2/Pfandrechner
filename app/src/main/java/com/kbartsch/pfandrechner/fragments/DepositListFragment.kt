package com.kbartsch.pfandrechner.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kbartsch.pfandrechner.R
import com.kbartsch.pfandrechner.adapters.DepositAdapter
import com.kbartsch.pfandrechner.models.Deposit
import com.kbartsch.pfandrechner.models.DepositFactory
import com.kbartsch.pfandrechner.models.DepositListType



class DepositListFragment(passedContext: Context, val totalItem: TextView) : Fragment(){
    val depositFactory : DepositFactory = DepositFactory(passedContext)
    val ARG_LIST_TYPE = "LIST_TYPE"
    private val passThroughContext : Context = passedContext

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_main, container, false)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.depositRecyclerView) as RecyclerView
        val listType = this.arguments.getSerializable(ARG_LIST_TYPE) as DepositListType
        var deposits = ArrayList<Deposit>()
        when (listType) {
            DepositListType.All -> deposits = depositFactory.deposits
            DepositListType.Sample -> deposits = depositFactory.sampledeposits
        }
        recyclerView.adapter = DepositAdapter(deposits, totalItem)
        recyclerView.layoutManager = LinearLayoutManager(passThroughContext)
        return rootView
    }

    companion object {
        val ARG_LIST_TYPE = "LIST_TYPE"

        fun newInstance(listType: DepositListType, context: Context, totalItem: TextView): DepositListFragment {
            val fragment = DepositListFragment(context, totalItem)
            val args = Bundle()
            args.putSerializable(ARG_LIST_TYPE, listType)
            fragment.arguments = args
            return fragment
        }
    }


}