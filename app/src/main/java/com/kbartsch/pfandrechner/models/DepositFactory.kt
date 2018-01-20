package com.kbartsch.pfandrechner.models

import android.content.Context
import android.support.v4.content.ContextCompat
import android.graphics.drawable.Drawable



/**
 * Created by adunn on 7/5/17.
 */

class DepositFactory(private val context: Context) {

    val deposits: ArrayList<Deposit>
        get() {
            val result = ArrayList<Deposit>()
            result.add(Deposit("Bierflasche (Glas)", 0.08, getDrawableByName("bottle1")))
            result.add(Deposit("Glasflasche (Mehrweg)", 0.15, getDrawableByName("bottle2")))
            result.add(Deposit("Plastikflasche (Einweg)", 0.25, getDrawableByName("bottle3")))
            result.add(Deposit("Plastikflasche (Mehrweg)", 0.15, getDrawableByName("bottle4")))
            result.add(Deposit("Dose", 0.25, getDrawableByName("bottle5")))
            result.add(Deposit("Joghurtglas", 0.15, getDrawableByName("bottle6")))
            result.add(Deposit("Bügelfasche (Glas)", 0.15, getDrawableByName("bottle7")))
            result.add(Deposit("Kasten (Leer)", 1.50, getDrawableByName("crate_full")))
            result.add(Deposit("Halber Kasten (leer)", 0.75, getDrawableByName("crate_half")))
            return result
        }

    val sampledeposits: ArrayList<Deposit>
        get() {
            val result = ArrayList<Deposit>()
            result.add(Deposit("Einweg", 0.08, getDrawableByName("bottle1")))
            result.add(Deposit("Mehrweg", 0.15, getDrawableByName("bottle2")))
            return result
        }


    private fun getDrawableByName(name: String): Drawable {
        val resources = context.getResources()
        val resourceId = resources.getIdentifier(name, "drawable",
                context.getPackageName())
        return ContextCompat.getDrawable(context, resourceId)
    }
}
