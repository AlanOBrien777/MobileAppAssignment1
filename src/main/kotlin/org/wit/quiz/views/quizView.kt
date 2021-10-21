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
        var tempQuestionTwo:String?
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
            print("Enter a new Question 1 instead of [ "  + quiz.questionOne + " ] : ")
            tempQuestionOne = readLine()!!
            print("Enter a new Question 2 instead of [ "  + quiz.questionTwo + " ] : ")
            tempQuestionTwo = readLine()!!
            print("Enter a new Question 3 instead of [ "  + quiz.questionThree + " ] : ")
            tempQuestionThree = readLine()!!
            print("Enter a new Question 4 instead of [ "  + quiz.questionFour + " ] : ")
            tempQuestionFour = readLine()!!
            print("Enter a new Question 5 instead of [ "  + quiz.questionFive + " ] : ")
            tempQuestionFive = readLine()!!
            print("Enter a new Question 6 instead of [ "  + quiz.questionSix + " ] : ")
            tempQuestionSix = readLine()!!
            print("Enter a new Question 7 instead of [ "  + quiz.questionSeven + " ] : ")
            tempQuestionSeven = readLine()!!
            print("Enter a new Question 8 instead of [ "  + quiz.questionEight + " ] : ")
            tempQuestionEight = readLine()!!
            print("Enter a new Question 9 instead of [ "  + quiz.questionNine + " ] : ")
            tempQuestionNine = readLine()!!
            print("Enter a new Question 10 instead of [ "  + quiz.questionTen + " ] : ")
            tempQuestionTen = readLine()!!
            print("Enter a new Answer 1 instead of [ "  + quiz.answerOne + " ] : ")
            tempAnswerOne = readLine()!!
            print("Enter a new Answer 2 instead of [ "  + quiz.answerTwo + " ] : ")
            tempAnswerTwo = readLine()!!
            print("Enter a new Answer 3 instead of [ "  + quiz.answerThree + " ] : ")
            tempAnswerThree = readLine()!!
            print("Enter a new Answer 4 instead of [ "  + quiz.answerFour + " ] : ")
            tempAnswerFour = readLine()!!
            print("Enter a new Answer 5 instead of [ "  + quiz.answerFive + " ] : ")
            tempAnswerFive = readLine()!!
            print("Enter a new Answer 6 instead of [ "  + quiz.answerSix + " ] : ")
            tempAnswerSix = readLine()!!
            print("Enter a new Answer 7 instead of [ "  + quiz.answerSeven + " ] : ")
            tempAnswerSeven = readLine()!!
            print("Enter a new Answer 8 instead of [ "  + quiz.answerEight + " ] : ")
            tempAnswerEight = readLine()!!
            print("Enter a new Answer 9 instead of [ "  + quiz.answerNine + " ] : ")
            tempAnswerNine = readLine()!!
            print("Enter a new Answer 10 instead of [ "  + quiz.answerTen + " ] : ")
            tempAnswerTen = readLine()!!

            if (!tempQuizName.isNullOrEmpty() && !tempQuizGenre.isNullOrEmpty() && !tempQuestionOne.isNullOrEmpty() && !tempQuestionTwo.isNullOrEmpty() && !tempQuestionThree.isNullOrEmpty() && !tempQuestionFour.isNullOrEmpty() && !tempQuestionFive.isNullOrEmpty() && !tempQuestionSix.isNullOrEmpty() && !tempQuestionSeven.isNullOrEmpty() && !tempQuestionEight.isNullOrEmpty() && !tempQuestionNine.isNullOrEmpty() && !tempQuestionTen.isNullOrEmpty() && !tempAnswerOne.isNullOrEmpty() && !tempAnswerTwo.isNullOrEmpty() && !tempAnswerThree.isNullOrEmpty() && !tempAnswerFour.isNullOrEmpty() && !tempAnswerFive.isNullOrEmpty() && !tempAnswerSix.isNullOrEmpty() && !tempAnswerSeven.isNullOrEmpty() && !tempAnswerEight.isNullOrEmpty() && !tempAnswerNine.isNullOrEmpty() && !tempAnswerTen.isNullOrEmpty()) {
                quiz.quizName = tempQuizName
                quiz.quizGenre = tempQuizGenre
                quiz.questionOne = tempQuestionOne
                quiz.questionTwo = tempQuestionTwo
                quiz.questionThree = tempQuestionThree
                quiz.questionFour = tempQuestionFour
                quiz.questionFive = tempQuestionFive
                quiz.questionSix = tempQuestionSix
                quiz.questionSeven = tempQuestionSeven
                quiz.questionEight = tempQuestionEight
                quiz.questionNine = tempQuestionNine
                quiz.questionTen = tempQuestionTen

                quiz.answerOne = tempAnswerOne
                quiz.answerTwo = tempAnswerTwo
                quiz.answerThree = tempAnswerThree
                quiz.answerFour = tempAnswerFour
                quiz.answerFive = tempAnswerFive
                quiz.answerSix = tempAnswerSix
                quiz.answerSeven = tempAnswerSeven
                quiz.answerEight = tempAnswerEight
                quiz.answerNine = tempAnswerNine
                quiz.answerTen = tempAnswerTen
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