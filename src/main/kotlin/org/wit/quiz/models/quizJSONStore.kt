package org.wit.quiz.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import org.wit.quiz.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}

val JSON_FILE = "quizzes.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<quizModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

    class quizJSONStore : quizStore {

        var quizzes = mutableListOf<quizModel>()

        init {
            if (exists(JSON_FILE)) {
                deserialize()
            }
        }

        override fun delete(quiz: quizModel) {
            quizzes.remove(quiz)
            serialize()
        }

        override fun findAll(): MutableList<quizModel> {
            return quizzes
        }

        override fun findOne(id: Long) : quizModel? {
            var foundQuiz: quizModel? = quizzes.find { p -> p.id == id }
            return foundQuiz
        }

        override fun create(quiz: quizModel) {
            quiz.id = generateRandomId()
            quizzes.add(quiz)
            serialize()
        }

        override fun update(quiz: quizModel) {
            var foundQuiz = findOne(quiz.id!!)
            if (foundQuiz != null) {
                foundQuiz.title = quiz.title
                foundQuiz.description = quiz.description
            }
            serialize()
        }

        internal fun logAll() {
            quizzes.forEach { logger.info("${it}") }
        }

        private fun serialize() {
            val jsonString = gsonBuilder.toJson(quizzes, listType)
            write(JSON_FILE, jsonString)
        }

        private fun deserialize() {
            val jsonString = read(JSON_FILE)
            quizzes = Gson().fromJson(jsonString, listType)
        }
    }
}