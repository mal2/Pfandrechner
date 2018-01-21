package com.kbartsch.pfandrechner.adapters

import android.support.v4.app.Fragment
import com.kbartsch.pfandrechner.models.DepositListType
import com.kbartsch.pfandrechner.fragments.DepositListFragment
import com.kbartsch.pfandrechner.fragments.InfoFragment
import android.support.v4.app.FragmentPagerAdapter
import android.content.Context
import android.support.v4.app.FragmentManager
import android.widget.TextView


/**
 * Created by adunn on 7/5/17.
 */
class PageAdapter(fm: FragmentManager, private val context: Context, val totalItem : TextView) : FragmentPagerAdapter(fm) {
    
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return DepositListFragment.newInstance(DepositListType.All, context, totalItem)
            1 -> return InfoFragment.newInstance()

            // 1 -> return PuppyListFragment.newInstance(PuppyListType.LeashTrained, context)
            //1 -> return InfoFragment.newInstance(DepositListType.LeashTrained, context)
        }
        return DepositListFragment.newInstance(DepositListType.All, context, totalItem)
    }

    override fun getCount(): Int {
        // Show 5 total pages.
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // return empty to show no title. Delete this line to show tab titles
        return null
        /* switch (position) {
            case 0:
                return "All";
            case 1:
                return "Big";
            case 2:
                return "Small";
            case 3:
                return "Trained";
            case 4:
                return "Active";
        }
        return null;*/
    }

}
