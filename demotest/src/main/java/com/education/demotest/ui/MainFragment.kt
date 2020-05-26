package com.education.demotest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.av.smoothviewpager.Smoolider.SmoothViewpager
import com.education.demotest.Adapter.SmooliderAdapter
import com.education.demotest.R
import com.education.demotest.sharemodel.MainViewModel

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    var contentviewPageSlider: SmoothViewpager? = null
    private lateinit var viewModel: MainViewModel
    private var currentPosition = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        intializeUI()
        contentviewPageSlider = view.findViewById<View>(R.id.flashCardslider) as SmoothViewpager
        manage_widgets_on_swipe(0)
        return view
    }

    fun intializeUI(){
        val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.containerQuestion, QuestionFragment())
        fragmentTransaction.commit()
        setupCardStackView()
    }

    private fun setupCardStackView() {
        viewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)
        viewModel.liveFlashcardDetail.observe(requireActivity(), Observer {
           contentviewPageSlider!!.adapter = SmooliderAdapter(it, requireActivity())
            contentviewPageSlider!!.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {}
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageSelected(position: Int) {
                    // handle operations with current page
                    manage_widgets_on_swipe(position)
                }
            })
        })
    }


     fun manage_widgets_on_swipe(pos: Int) {
        val animH = intArrayOf(R.anim.slide_in_right, R.anim.slide_out_left)
        val animV = intArrayOf(R.anim.slide_in_top, R.anim.slide_out_bottom)
        val left2right: Boolean = pos < currentPosition
        if (left2right) {
            animH[0] = R.anim.slide_in_left
            animH[1] = R.anim.slide_out_right
            animV[0] = R.anim.slide_in_bottom
            animV[1] = R.anim.slide_out_top
        }
        currentPosition = pos
    }


}
