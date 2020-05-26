data class QuestionOfTheDay(
    val answer: Int,
    val hint: String,
    val hint_image: String,
    val level: Int,
    val name: String,
    val options: List<String>,
    val question_image: String,
    val question_type: String,
    val solution: String
)