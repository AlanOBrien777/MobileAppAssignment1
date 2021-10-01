package org.wit.quiz.main

import mu.KotlinLogging
import org.wit.quiz.models.quizModel

private val logger = KotlinLogging.logger {}

val quizzes = ArrayList<quizModel>()

fun main(args: Array<String>) {
    logger.info { "Launching Quiz Console App" }
    println("Quiz Kotlin App Version 1.0")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addQuiz()
            2 -> updateQuiz()
            3 -> listQuizzes()
            4 -> searchQuizzes()
            -99 -> dummyData()
            0 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != 0)
    logger.info { "Shutting Down Quiz Console App" }
}

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

fun addQuiz(){
    var aQuiz = quizModel()
    println("Add Quiz")
    println()
    print("Enter a Title : ")
    aQuiz.title = readLine()!!
    print("Enter a Description : ")
    aQuiz.description = readLine()!!

    if (aQuiz.title.isNotEmpty() && aQuiz.description.isNotEmpty()) {
        aQuiz.id = quizzes.size.toLong()
        quizzes.add(aQuiz.copy())
        logger.info("Quiz Added : [ $aQuiz ]")
    }
    else
        logger.info("Quiz Not Added")
}

fun updateQuiz() {
    println("Update Quiz")
    println()
    listQuizzes()
    var searchId = getId()
    val aQuiz = search(searchId)

    if(aQuiz != null) {
        print("Enter a new Title for [ " + aQuiz.title + " ] : ")
        aQuiz.title = readLine()!!
        print("Enter a new Description for [ " + aQuiz.description + " ] : ")
        aQuiz.description = readLine()!!
        println(
            "You updated [ " + aQuiz.title + " ] for title " +
                    "and [ " + aQuiz.description + " ] for description"
        )
    }
    else
        println("Quiz Not Updated...")
}

fun listQuizzes() {
    println("List All Quizzes")
    println()
    quizzes.forEach { logger.info("${it}") }
    println()
}

fun searchQuizzes() {

    var searchId = getId()
    val aQuiz = search(searchId)

    if(aQuiz != null)
        println("Quiz Details [ $aQuiz ]")
    else
        println("Quiz Not Found...")
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

fun search(id: Long) : quizModel? {
    var foundQuiz: quizModel? = quizzes.find { p -> p.id == id }
    return foundQuiz
}

fun dummyData() {
    quizzes.add(quizModel(1, "New York New York", "So Good They Named It Twice"))
    quizzes.add(quizModel(2, "Ring of Kerry", "Some place in the Kingdom"))
    quizzes.add(quizModel(3, "Waterford City", "You get great Blaas Here!!"))
}