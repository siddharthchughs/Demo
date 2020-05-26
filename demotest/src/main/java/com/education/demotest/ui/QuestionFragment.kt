package com.education.demotest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.education.demotest.R
import com.education.demotest.sharemodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_question.*

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment(), View.OnClickListener {

    var isChecked: Boolean = false
    private lateinit var viewModel: MainViewModel
    lateinit var answerOptions: RadioGroup
    var fragment: Fragment ?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question, container, false)
        val btnChoiceone = view.findViewById<Button>(R.id.btnSelectOne)
        val btnChoicetwo = view.findViewById<Button>(R.id.btnSelectTwo)
        val btnChoicethree = view.findViewById<Button>(R.id.btnSelectThree)
        val btnChoicefour = view.findViewById<Button>(R.id.btnSelectFour)
        viewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)
        viewModel.liveData.observe(requireActivity(), Observer {

            for (qd in it) {
                tv_Question.text = qd.question_of_the_day.name
                btnChoiceone.text = qd.question_of_the_day.options.get(0)
                btnChoicetwo.text = (qd.question_of_the_day.options.get(1))
                btnChoicethree.text = qd.question_of_the_day.options.get(2)
                btnChoicefour.text = qd.question_of_the_day.options.get(3)
            }
        })
        btnChoiceone.setOnClickListener(this)
        btnChoicetwo.setOnClickListener(this)
        btnChoicethree.setOnClickListener(this)
        btnChoicefour.setOnClickListener(this)
        return view
    }

    fun flipCard(boolean: Boolean) {
        if (isChecked == boolean) {
            requireActivity().supportFragmentManager.beginTransaction().setCustomAnimations(
                R.anim.cardivew_flip_right_in,
                R.anim.cardivew_flip_right_full
            )
                .replace(R.id.containerQuestion, WrongAnswerFragment())
        } else {
            requireActivity().supportFragmentManager.beginTransaction().setCustomAnimations(
                R.anim.cardivew_flip_right_in, R.anim.cardivew_flip_right_full
            )
                .replace(R.id.containerQuestion, RightAnswerFragment())
        }
            .commit()
    }

    override fun onClick(v: View?) {
       var viewid = v?.id
        if (R.id.btnSelectOne == viewid) {
            flipCard(false)
        }
        if (R.id.btnSelectTwo == viewid) {
            flipCard(false)
        }
        if (R.id.btnSelectThree == viewid) {
            flipCard(false)
        }
        if (R.id.btnSelectFour == viewid) {
            flipCard(true)
        }


    }


}