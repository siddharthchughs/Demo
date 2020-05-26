package com.education.demotest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.education.demotest.R
import com.education.demotest.helper.UtilityCompanion
import kotlinx.android.synthetic.main.fragment_wrong_answer.*

/**
 * A simple [Fragment] subclass.
 */
class WrongAnswerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_wrong_answer, container, false)
        val value: String? = arguments?.getString("correctanswer")
        if(value!=null){
            tv_Output.text = value
        }

        return view
    }

}
