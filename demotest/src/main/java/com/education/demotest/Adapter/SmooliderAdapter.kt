package com.education.demotest.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.av.smoothviewpager.Smoolider.SmoothViewpager
import com.education.demotest.R
import com.education.demotest.models.FlashcardDetail
import com.rishabhharit.roundedimageview.RoundedImageView

class SmooliderAdapter(private val feedItemList: List<FlashcardDetail>, private val mContext: Context) : PagerAdapter() {

    private val is_autoplay = false
    private val currentPosition = 0
    private val viewPager: SmoothViewpager? = null


    override fun getCount(): Int { return feedItemList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): View {
        val layoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.item_layout_cards, container, false)

        val tv_heading = view.findViewById<TextView>(R.id.tv_heading)
        val tv_subTitle = view.findViewById<TextView>(R.id.tv_Subtitle)

        tv_heading.text = feedItemList.get(position).title
        tv_subTitle.text = feedItemList.get(position).description

        container.addView(view)
        return view
    }

    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(
        view: View,
        `object`: Any
    ): Boolean {
        return view == `object`
    }

}