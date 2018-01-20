package com.kbartsch.pfandrechner.models

import android.widget.ImageView
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import com.kbartsch.pfandrechner.R
import com.kbartsch.pfandrechner.totalMoney


/**
 * Created by adunn on 7/5/17.
 */
class DepositHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nump: NumberPicker = itemView.findViewById<NumberPicker>(R.id.numberPicker)
    private val button_add: Button = itemView.findViewById<Button>(R.id.button_add)
    private val button_sub: Button = itemView.findViewById<Button>(R.id.button_sub)
    private val itemTotal: TextView = itemView.findViewById<TextView>(R.id.ItemTextViewTotal)
    private val depositImage: ImageView = itemView.findViewById<ImageView>(R.id.itemImageView)
    private val depositName: TextView = itemView.findViewById(R.id.ItemTextViewName)
    private val depositVal: TextView = itemView.findViewById(R.id.ItemTextViewPer)

    fun updateWithDeposit(deposit: Deposit) {
        depositImage.setImageDrawable(deposit.imageFile)
        depositName.text = deposit.name
        depositVal.text = deposit.price.toString() + " €/Stk"
        itemTotal.text = "0.00 €"
        nump.minValue = 0
        nump.maxValue = 100
        nump.wrapSelectorWheel = false

        nump.setOnValueChangedListener(NumberPicker.OnValueChangeListener { picker, oldVal, newVal ->
            //Display the newly selected number from picker
            nump.value = newVal
            if (newVal >= oldVal) {
                totalMoney += ((newVal - oldVal)*deposit.price).toFloat()

            } else {
                totalMoney -= ((oldVal - newVal)*deposit.price).toFloat()
            }
            itemTotal.text = "%.2f".format((nump.value * deposit.price)) + " €"
            //TextTotal.text = "%.2f".format(totalMoney) + " €"
        })

        button_add.setOnClickListener {
            nump.value += 1
            totalMoney += deposit.price.toFloat()
            itemTotal.text  = "%.2f".format((nump.value * deposit.price)) + " €"
            //TextTotal.text      = "%.2f".format(totalMoney) + " €"
        }
        button_sub.setOnClickListener {
            if (nump.value > 0) {
                nump.value -= 1
                totalMoney -= deposit.price.toFloat()
                itemTotal.text = "%.2f".format((nump.value * deposit.price)) + " €"
                //TextTotal.text      = "%.2f".format(totalMoney) + " €"
            }
        }
    }
}