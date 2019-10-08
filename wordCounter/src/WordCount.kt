import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {

    if (args.size == 0){
        println("You must provide a file name.")
    } else {
        // Read a file and turn into a string, test.txt > allTheWords
        val inputStream: InputStream = File(args[0]).inputStream()

        val allTheWords = inputStream.bufferedReader().use { it.readText() }

        // Make a list of all the words seperated out
        val words = allTheWords
            .replace(",","")
            .replace("!","")
            .replace(".","")
            .replace("\n", "")
            .replace("\"", "")
            .replace("?","")
            .replace("//", "")
            .replace("(","")
            .replace(")","")
            .replace("*", "")
            .replace("()","")
            .replace("[]","")
            .replace("[","")
            .replace("]","")
            .replace("{","")
            .replace("}","")
            .replace("/","")
            .replace("'","")
            .replace(">", "")
            .replace("<", "")
            .replace("—", "")
            .replace("+","")
            .replace("•", "")
            .replace(":","")
            .replace("=","")
            .split(" ")

        // Get a counted list of all the words
        val wordCounter = mutableMapOf<String,Int>()

        for (word in words){
            if (word != ""){

                if (wordCounter[word.capitalize()] == null) {
                    // We know it's not in the map
                    wordCounter[word.capitalize()] = 1
                }else {
                    val wordCount = wordCounter[word.capitalize()]!!
                    wordCounter[word.capitalize()] = wordCount + 1
                }
            }
        }

        for(word in wordCounter) {
    //        println(word)
        }

        //Convert Map to List
        val wordList = wordCounter.toList()
        //Sort the counted list
        val sortedList = wordList.sortedWith(compareBy({it.second}))
        // Print a sorted list of the most popular words
        for (word in sortedList) {
            println("${word.first} - ${word.second}")
        }
    }
}