package com.education.demotest.helper

import android.content.Context
import android.widget.RadioButton
import android.widget.Toast
import com.education.demotest.R
import com.education.demotest.ui.QuestionFragment

class UtilityCompanion {

    companion object{

        fun ToastMessage(con:Context,msg : String){
            Toast.makeText(con,msg,Toast.LENGTH_SHORT).show()
        }

        fun getTextFromResouces(con:Context,resourcesID:Int):String{
            return con.resources.openRawResource(resourcesID).use {
                it.bufferedReader().use {
                    it.readText()
                }
            }
        }


    }


}