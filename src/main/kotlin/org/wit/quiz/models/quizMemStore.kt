package org.wit.quiz.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class quizMemStore : quizStore {

    val quizzes = ArrayList<quizModel>()

    override fun findAll(): List<quizModel> {
        return quizzes
    }

    override fun findOne(id: Long) : quizModel? {
        var foundQuiz: quizModel? = quizzes.find { p -> p.id == id }
        return foundQuiz
    }

    override fun create(quiz: quizModel) {
        quiz.id = getId()
        quizzes.add(quiz)
        logAll()
    }

    override fun update(quiz: quizModel) {
        var foundQuiz = findOne(quiz.id!!)
        if (foundQuiz != null) {
            foundQuiz.quizName = quiz.quizName
            foundQuiz.quizGenre = quiz.quizGenre
        }
    }

    override fun delete(quiz: quizModel) {
        quizzes.remove(quiz)
    }

    internal fun logAll() {
        quizzes.forEach { logger.info("${it}") }
    }
}