package org.wit.quiz.controllers

import mu.KotlinLogging
import org.wit.quiz.models.quizJSONStore
import org.wit.quiz.models.quizMemStore
import org.wit.quiz.models.quizModel
import org.wit.quiz.views.quizView
import java.util.*
import kotlin.random.Random.Default.nextInt

class quizController {

    //val quizzes = quizMemStore()
    val quizzes = quizJSONStore()
    val quizView = quizView()
    val logger = KotlinLogging.logger {}
    val red = "\u001b[31m"
    val reset = "\u001b[0m"

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
                3 -> play()
                4 -> list()
                5 -> search()
                6 -> delete()
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

    var quizScore: Int = 0

    fun play(){
        val newId = Random().nextInt(quizzes.quizzes.size)
        val aQuiz = search(newId.toLong())

        var tempAnswerOne: String?
        var tempAnswerTwo: String?
        var tempAnswerThree: String?
        var tempAnswerFour: String?
        var tempAnswerFive: String?
        var tempAnswerSix: String?
        var tempAnswerSeven: String?
        var tempAnswerEight: String?
        var tempAnswerNine: String?
        var tempAnswerTen: String?

        if(aQuiz != null){
            println(red + "Question 1 : " + aQuiz.questionOne + " " + reset)
            print("Answer 1 : ")
            tempAnswerOne =""+ readLine()!!

            println(red + "Question 2 : " + aQuiz.questionTwo + " " + reset)
            print("Answer 2 : ")
            tempAnswerTwo =""+ readLine()!!

            println(red + "Question 3 : " + aQuiz.questionThree + " " + reset)
            print("Answer 3 : ")
            tempAnswerThree =""+ readLine()!!

            println(red + "Question 4 : " + aQuiz.questionFour + " " + reset)
            print("Answer 4 : ")
            tempAnswerFour =""+ readLine()!!

            println(red + "Question 5 : " + aQuiz.questionFive + " " + reset)
            print("Answer 5 : ")
            tempAnswerFive =""+ readLine()!!

            println(red + "Question 6 : " + aQuiz.questionSix + " " + reset)
            print("Answer 6 : ")
            tempAnswerSix =""+ readLine()!!

            println(red + "Question 7 : " + aQuiz.questionSeven + " " + reset)
            print("Answer 7 : ")
            tempAnswerSeven =""+ readLine()!!

            println(red + "Question 8 : " + aQuiz.questionEight + " " + reset)
            print("Answer 8 : ")
            tempAnswerEight =""+ readLine()!!

            println(red + "Question 9 : " + aQuiz.questionNine + " " + reset)
            print("Answer 9 : ")
            tempAnswerNine =""+ readLine()!!

            println(red + "Question 10 : " + aQuiz.questionTen + " " + reset)
            print("Answer 10 : ")
            tempAnswerTen = ""+ readLine()!!

            tempAnswerOne = tempAnswerOne.toLowerCase()
            tempAnswerTwo = tempAnswerTwo.toLowerCase()
            tempAnswerThree = tempAnswerThree.toLowerCase()
            tempAnswerFour = tempAnswerFour.toLowerCase()
            tempAnswerFive = tempAnswerFive.toLowerCase()
            tempAnswerSix = tempAnswerSix.toLowerCase()
            tempAnswerSeven = tempAnswerSeven.toLowerCase()
            tempAnswerEight = tempAnswerEight.toLowerCase()
            tempAnswerNine = tempAnswerNine.toLowerCase()
            tempAnswerTen = tempAnswerTen.toLowerCase()


            if(tempAnswerOne != null && tempAnswerTwo != null && tempAnswerThree !=null && tempAnswerFour !=null && tempAnswerFive !=null && tempAnswerSix !=null && tempAnswerSeven !=null && tempAnswerEight !=null && tempAnswerNine !=null && tempAnswerTen !=null ){
                if(tempAnswerOne == aQuiz.answerOne){
                    quizScore++
                }
                if(tempAnswerTwo == aQuiz.answerTwo){
                    quizScore++
                }
                if(tempAnswerThree == aQuiz.answerThree){
                    quizScore++
                }
                if(tempAnswerFour == aQuiz.answerFour){
                    quizScore++
                }
                if(tempAnswerFive == aQuiz.answerFive){
                    quizScore++
                }
                if(tempAnswerSix == aQuiz.answerFive){
                    quizScore++
                }
                if(tempAnswerSeven == aQuiz.answerSeven){
                    quizScore++
                }
                if(tempAnswerEight == aQuiz.answerEight){
                    quizScore++
                }
                if(tempAnswerNine == aQuiz.answerNine){
                    quizScore++
                }
                if(tempAnswerTen == aQuiz.answerTen){
                    quizScore++
                }
            }
            else{
                print("You entered an Invalid Answer Type")
            }

        }
        else{
            println("Could not find a quiz")
        }

        println("\nQuestion 1 : " + aQuiz?.questionOne + " ")
        println("Answer 1 : " + aQuiz?.answerOne + " ")
        println("Question 2 : " + aQuiz?.questionTwo + " ")
        println("Answer 2 : " + aQuiz?.answerTwo + " ")
        println("Question 3 : " + aQuiz?.questionThree + " ")
        println("Answer 3 : " + aQuiz?.answerThree + " ")
        println("Question 4 : " + aQuiz?.questionFour + " ")
        println("Answer 4 : " + aQuiz?.answerFour + " ")
        println("Question 5 : " + aQuiz?.questionFive + " ")
        println("Answer 5 : " + aQuiz?.answerFive + " ")
        println("Question 6 : " + aQuiz?.questionSix + " ")
        println("Answer 6 : " + aQuiz?.answerSix + " ")
        println("Question 7 : " + aQuiz?.questionSeven + " ")
        println("Answer 7 : " + aQuiz?.answerSeven + " ")
        println("Question 8 : " + aQuiz?.questionEight + " ")
        println("Answer 8 : " + aQuiz?.answerEight + " ")
        println("Question 9 : " + aQuiz?.questionNine + " ")
        println("Answer 9 : " + aQuiz?.answerNine + " ")
        println("Question 10 : " + aQuiz?.questionTen + " ")
        println("Answer 10 : " + aQuiz?.answerTen + " ")

        println("\nYour Score is : $quizScore ")

        quizScore = 0
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

    fun delete() {
        quizView.listQuizzes(quizzes)
        var searchId = quizView.getId()
        val aQuiz = search(searchId)

        if(aQuiz != null) {
            quizzes.delete(aQuiz)
            println("Quiz Deleted...")
            quizView.listQuizzes(quizzes)
        }
        else
            println("Quiz Not Deleted...")
    }

    fun search() {
        val aQuiz = search(quizView.getId())!!
        quizView.showQuiz(aQuiz)
    }


    fun search(id: Long) : quizModel? {
        var foundQuiz = quizzes.findOne(id)
        return foundQuiz
    }

}