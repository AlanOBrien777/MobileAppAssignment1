package org.wit.quiz.controllers

import mu.KotlinLogging
import org.wit.quiz.models.quizMemStore
import org.wit.quiz.models.quizModel
import org.wit.quiz.views.quizView

class quizController {

    val quizzes = quizMemStore()
    val quizView = quizView()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Quiz Console App" }
        println("Quiz Kotlin App Version 1.0")
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> update()
                3 -> list()
                4 -> search()
                -99 -> dummyData()
                0 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != 0)
        logger.info { "Shutting Down Quiz Console App" }
    }

    fun menu() :Int { return quizView.menu() }

    fun add(){
        var aQuiz = quizModel()

        if (quizView.addQuizData(aQuiz))
            quizzes.create(aQuiz)
        else
            logger.info("Quiz Not Added")
    }

    fun list() {
        quizView.listQuizzes(quizzes)
    }

    fun update() {

        quizView.listQuizzes(quizzes)
        var searchId = quizView.getId()
        val aQuiz = search(searchId)

        if(aQuiz != null) {
            if(quizView.updateQuizData(aQuiz)) {
                quizzes.update(aQuiz)
                quizView.showQuiz(aQuiz)
                println("Quiz Updated : [ $aQuiz ]")
            }
            else
                logger.info("Quiz Not Updated")
        }
        else
            println("Quiz Not Updated...")
    }

    fun search() {
        val aQuiz = search(quizView.getId())!!
        quizView.showQuiz(aQuiz)
    }


    fun search(id: Long) : quizModel? {
        var foundQuiz = quizzes.findOne(id)
        return foundQuiz
    }

    fun dummyData() {
        quizzes.create(quizModel(title = "New York New York", description = "So Good They Named It Twice"))
        quizzes.create(quizModel(title= "Ring of Kerry", description = "Some place in the Kingdom"))
        quizzes.create(quizModel(title = "Waterford City", description = "You get great Blaas Here!!"))
    }
}