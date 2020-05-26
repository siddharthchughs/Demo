package com.education.demotest.sharemodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.education.demotest.helper.RepoSection

class MainViewModel(app: Application) : AndroidViewModel(app) {

   private val repdata = RepoSection(app)
   val liveData = repdata.liverepo
   val liveFlashcardDetail = repdata.liverepoFlashcards

}