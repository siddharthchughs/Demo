package com.education.demotest.models
class Quest {
    data class QustHour(
        val question_of_the_day: QuestionOfTheDayX
    )
    data class QuestionOfTheDayX(
        val hint: String,
        val hint_image: String,
        val level: Int,
        val name: String,
        val answers: Int,
        val options: List<String>,
        val question_image: String,
        val question_type: String,
        val solution: String
    )
}