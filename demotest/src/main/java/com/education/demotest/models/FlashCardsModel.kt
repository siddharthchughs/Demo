package com.education.demotest.models

    data class FlashcardDetail(
        val additional_info_deck_code: String,
        val additional_info_display: Int,
        val additional_info_link: String,
        val additional_info_type: String,
        val code: String,
        val description: String,
        val image_url: String,
        val reading_time: String,
        val title: String
    )
