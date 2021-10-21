package org.wit.quiz.views

import org.wit.quiz.models.quizJSONStore
import org.wit.quiz.models.quizMemStore
import org.wit.quiz.models.quizModel

class quizView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Create a Quiz")
        println(" 2. Edit a Quiz")
        println(" 3. List All Quizzes")
        println(" 4. Search Quizzes")
        println(" 5. Delete Quiz")
        println(" 0. Exit")
        println()
        print("Enter Option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listQuizzes(quizzes : quizJSONStore) {
        println("List All Quizzes")
        println()
        quizzes.logAll()
        println()
    }

    fun showQuiz(quiz : quizModel) {
        if(quiz != null)
            println("Quiz Details [ $quiz ]")
        else
            println("Quiz Not Found...")
    }

    fun addQuizData(quiz : quizModel) : Boolean {

        println()
        print("Enter a Quiz Name : ")
        quiz.quizName = readLine()!!
        print("Enter a Quiz Genre : ")
        quiz.quizGenre = readLine()!!
        print("Enter Question 1 : ")
        quiz.questionOne = readLine()!!
        print("Enter the Answer to Question 1 : ")
        quiz.answerOne = readLine()!!
        print("Enter Question 2 : ")
        quiz.questionTwo = readLine()!!
        print("Enter the Answer to Question 2 : ")
        quiz.answerTwo = readLine()!!
        print("Enter Question 3 : ")
        quiz.questionThree = readLine()!!
        print("Enter the Answer to Question 3 : ")
        quiz.answerThree = readLine()!!
        print("Enter Question 4 : ")
        quiz.questionFour = readLine()!!
        print("Enter the Answer to Question 4 : ")
        quiz.answerFour = readLine()!!
        print("Enter Question 5 : ")
        quiz.questionFive = readLine()!!
        print("Enter the answer to Question 5 : ")
        quiz.answerFive = readLine()!!
        print("Enter Question 6 : ")
        quiz.questionSix = readLine()!!
        print("Enter the Answer to Question 6 : ")
        quiz.answerSix = readLine()!!
        print("Enter Question 7 : ")
        quiz.questionSeven = readLine()!!
        print("Enter the Answer to Question 7 : ")
        quiz.answerSeven = readLine()!!
        print("Enter Question 8 : ")
        quiz.questionEight = readLine()!!
        print("Enter the Answer to Question 8 : ")
        quiz.answerEight = readLine()!!
        print("Enter Question 9 : ")
        quiz.questionNine = readLine()!!
        print("Enter the Answer to Question 9 : ")
        quiz.answerNine = readLine()!!
        print("Enter Question 10 : ")
        quiz.questionTen = readLine()!!
        print("Enter the answer to Question 10 : ")
        quiz.answerTen = readLine()!!


        return quiz.quizName.isNotEmpty() && quiz.quizGenre.isNotEmpty() && quiz.questionOne.isNotEmpty() && quiz.questionTwo.isNotEmpty() && quiz.questionThree.isNotEmpty() && quiz.questionFour.isNotEmpty() && quiz.questionFive.isNotEmpty() && quiz.questionSix.isNotEmpty() && quiz.questionSeven.isNotEmpty() && quiz.questionEight.isNotEmpty() && quiz.questionNine.isNotEmpty() && quiz.questionTen.isNotEmpty() && quiz.answerOne.isNotEmpty() && quiz.answerTwo.isNotEmpty() && quiz.answerThree.isNotEmpty() && quiz.answerFour.isNotEmpty() && quiz.answerFive.isNotEmpty() && quiz.answerSix.isNotEmpty() && quiz.answerSeven.isNotEmpty() && quiz.answerEight.isNotEmpty() && quiz.answerNine.isNotEmpty() && quiz.answerTen.isNotEmpty()
    }

    fun updateQuizData(quiz : quizModel) : Boolean {

        var tempQuizName: String?
        var tempQuizGenre: String?
        var tempQuestionOne:String?
        var tempQuestionTow:String?
        var tempQuestionThree:String?
        var tempQuestionFour:String?
        var tempQuestionFive:String?
        var tempQuestionSix:String?
        var tempQuestionSeven:String?
        var tempQuestionEight:String?
        var tempQuestionNine:String?
        var tempQuestionTen:String?
        var tempAnswerOne:String?
        var tempAnswerTwo:String?
        var tempAnswerThree:String?
        var tempAnswerFour:String?
        var tempAnswerFive:String?
        var tempAnswerSix:String?
        var tempAnswerSeven:String?
        var tempAnswerEight:String?
        var tempAnswerNine:String?
        var tempAnswerTen:String?

        if (quiz != null) {
            print("Enter a new Quiz Name for [ " + quiz.quizName + " ] : ")
            tempQuizName = readLine()!!
            print("Enter a new Quiz Genre for [ " + quiz.quizGenre + " ] : ")
            tempQuizGenre = readLine()!!

            if (!tempQuizName.isNullOrEmpty() && !tempQuizGenre.isNullOrEmpty()) {
                quiz.quizName = tempQuizName
                quiz.quizGenre = tempQuizGenre
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter id to Search/Update/Delete: ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}