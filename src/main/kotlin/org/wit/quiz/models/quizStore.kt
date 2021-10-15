package org.wit.quiz.models

interface quizStore {
    fun findAll(): List<quizModel>
    fun findOne(id: Long): quizModel?
    fun create(quiz: quizModel)
    fun update(quiz: quizModel)
}