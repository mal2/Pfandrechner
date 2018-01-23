package com.kbartsch.pfandrechner.models

import android.widget.ImageView
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import com.kbartsch.pfandrechner.R


/**
 * Created by adunn on 7/5/17.
 */

class DepositHolder(itemView: View, val totalItem: TextView, val deposits: ArrayList<Deposit>) : RecyclerView.ViewHolder(itemView) {
    private val numberOfItem: NumberPicker = itemView.findViewById(R.id.numberPicker)
    private val buttonAdd: Button = itemView.findViewById(R.id.button_add)
    private val buttonSub: Button = itemView.findViewById(R.id.button_sub)
    private val itemTotal: TextView = itemView.findViewById(R.id.ItemTextViewTotal)
    private val depositImage: ImageView = itemView.findViewById(R.id.itemImageView)
    private val depositName: TextView = itemView.findViewById(R.id.ItemTextViewName)
    private val depositVal: TextView = itemView.findViewById(R.id.ItemTextViewPer)

    fun updateWithDeposit(deposit: Deposit) {
        depositImage.setImageDrawable(deposit.imageFile)
        depositName.text = deposit.name
        depositVal.text = deposit.price.toString() + " €/Stk"
        itemTotal.text = "0.00 €"
        numberOfItem.minValue = 0
        numberOfItem.maxValue = 10
        numberOfItem.wrapSelectorWheel = false

        fun update(Val: Int){
            when (Val) {
                -1   -> if (numberOfItem.value > 0) numberOfItem.value -= 1
                1    -> numberOfItem.value += 1
                else -> numberOfItem.value = Val
            }
            var totalMoney = 0.0
            deposits[deposits.indexOf(deposit)].count = numberOfItem.value
            deposits.forEach { element ->
                totalMoney += element.count*element.price
            }
            itemTotal.text = "%.2f".format((numberOfItem.value * deposit.price)) + " €"
            totalItem.text = "Gesamt " + "%.2f".format(totalMoney) + " €"

        }

        numberOfItem.setOnValueChangedListener( { _, _, newVal ->
            update(newVal)
            //Display the newly selected number from picker
            //numberOfItem.value = newVal
            //itemTotal.text = "%.2f".format((numberOfItem.value * deposit.price)) + " €"
            //totalMoney = numberOfItem.value * deposit.price
            //totalItem.text = "%.2f".format(numberOfItem.value * deposit.price) + " €"
        })

        buttonAdd.setOnClickListener {
            update(1)
            //numberOfItem.value += 1
            //totalMoney += numberOfItem.value * deposit.price
            //itemTotal.text = "%.2f".format((numberOfItem.value * deposit.price)) + " €"
            //totalItem.text = "%.2f".format(totalMoney) + " €"
        }
        buttonSub.setOnClickListener {
            update(-1)
            //if (numberOfItem.value > 0) {
            //    numberOfItem.value -= 1
            //    totalMoney -= numberOfItem.value * deposit.price
            //    itemTotal.text = "%.2f".format((numberOfItem.value * deposit.price)) + " €"
            //    totalItem.text = "%.2f".format(totalMoney) + " €"
        }
    }
}
