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

//fun generateRandomId(): Long {
//    return Random().nextLong()
//}

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

    override fun findOne(id: Long): quizModel? {
        var foundQuiz: quizModel? = quizzes.find { p -> p.id == id }
        return foundQuiz
    }

    override fun create(quiz: quizModel) {
        if(quizzes.size > 0){
            lastId = (quizzes.size).toLong()
        }
        else{
            lastId = 0
        }
        quiz.id = lastId++
        quizzes.add(quiz)
        serialize()
    }

    override fun update(quiz: quizModel) {
        var foundQuiz = findOne(quiz.id!!)
        if (foundQuiz != null) {

            foundQuiz.quizName = quiz.quizName
            foundQuiz.quizGenre = quiz.quizGenre
            foundQuiz.questionOne = quiz.questionOne
            foundQuiz.questionTwo = quiz.questionTwo
            foundQuiz.questionThree = quiz.questionThree
            foundQuiz.questionFour = quiz.questionFour
            foundQuiz.questionFive = quiz.questionFive
            foundQuiz.questionSix = quiz.questionSix
            foundQuiz.questionSeven = quiz.questionSeven
            foundQuiz.questionEight = quiz.questionEight
            foundQuiz.questionNine = quiz.questionNine
            foundQuiz.questionTen = quiz.questionTen

            foundQuiz.answerOne = quiz.answerOne
            foundQuiz.answerTwo = quiz.answerTwo
            foundQuiz.answerThree = quiz.answerThree
            foundQuiz.answerFour = quiz.answerFour
            foundQuiz.answerFive = quiz.answerFive
            foundQuiz.answerSix = quiz.answerSix
            foundQuiz.answerSeven = quiz.answerSeven
            foundQuiz.answerEight = quiz.answerEight
            foundQuiz.answerNine = quiz.answerNine
            foundQuiz.answerTen = quiz.answerTen
        }
        serialize()
    }

    internal fun logAll() {
        quizzes.forEach { println("${it}") }
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
