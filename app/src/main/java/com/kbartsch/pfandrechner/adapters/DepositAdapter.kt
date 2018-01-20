package com.kbartsch.pfandrechner.adapters

import android.support.v7.widget.RecyclerView
import com.kbartsch.pfandrechner.models.DepositHolder
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.view.ViewGroup
import com.kbartsch.pfandrechner.R
import com.kbartsch.pfandrechner.models.Deposit


/**
 * Created by adunn on 7/5/17.
 */

class DepositAdapter(private val deposits: ArrayList<Deposit>) : RecyclerView.Adapter<DepositHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepositHolder {
        val depositItem = LayoutInflater.from(parent.context).inflate(R.layout.deposit_item, parent, false) as LinearLayout
        return DepositHolder(depositItem)
    }

    override fun onBindViewHolder(holder: DepositHolder, position: Int) {
        holder.updateWithDeposit(deposits[position])
    }

    override fun getItemCount(): Int {
        return deposits.toArray().count();
    }

}