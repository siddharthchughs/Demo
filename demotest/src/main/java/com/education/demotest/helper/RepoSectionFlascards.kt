//package com.education.demotest.helper
//
//import android.app.Application
//import com.education.demotest.R
//import com.squareup.moshi.JsonAdapter
//import com.squareup.moshi.Moshi
//import com.squareup.moshi.Types
//import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
//import androidx.lifecycle.MutableLiveData
//import com.education.demotest.models.FlashcardDetail
//import com.education.demotest.models.Quest
//
//
//class RepoSectionFlascards(val app: Application) {
//
//    private val detail  = Types.newParameterizedType(List::class.java,Quest.QustHour::class.java)
//    private val flash_detail  = Types.newParameterizedType(List::class.java,FlashcardDetail::class.java)
//    val liverepoFlashcards  = MutableLiveData<List<FlashcardDetail>>()
//
//
//    init {
//        getFlashCardsDetail()
//    }
//
//
//
//    fun getFlashCardsDetail() {
//        val text = UtilityCompanion.getTextFromResouces(app, R.raw.flash_card)
//        val moshi = Moshi.Builder()
//            .add(KotlinJsonAdapterFactory())
//            .build()
//        val adapter : JsonAdapter<List<FlashcardDetail>> = moshi.adapter(flash_detail)
//        liverepoFlashcards.value= adapter.fromJson(text)?: emptyList()
//    }
//
//
//
//
//}