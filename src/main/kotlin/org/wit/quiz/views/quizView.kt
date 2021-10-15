package org.wit.quiz.views

import org.wit.quiz.models.quizMemStore
import org.wit.quiz.models.quizModel

class quizView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Add Quiz")
        println(" 2. Update Quiz")
        println(" 3. List All Quizzes")
        println(" 4. Search Quizzes")
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

    fun listQuizzes(quizzes : quizMemStore) {
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
        print("Enter a Title : ")
        quiz.title = readLine()!!
        print("Enter a Description : ")
        quiz.description = readLine()!!

        return quiz.title.isNotEmpty() && quiz.description.isNotEmpty()
    }

    fun updateQuizData(quiz : quizModel) : Boolean {

        var tempTitle: String?
        var tempDescription: String?

        if (quiz != null) {
            print("Enter a new Title for [ " + quiz.title + " ] : ")
            tempTitle = readLine()!!
            print("Enter a new Description for [ " + quiz.description + " ] : ")
            tempDescription = readLine()!!

            if (!tempTitle.isNullOrEmpty() && !tempDescription.isNullOrEmpty()) {
                quiz.title = tempTitle
                quiz.description = tempDescription
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}