package com.housekeepingmaidaffordable.myquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var answerWord:TextView
    lateinit var showWord:TextView
    lateinit var enterWord:EditText
    lateinit var check:Button
    lateinit var change:Button
    lateinit var day:String
    lateinit var random:Random

    internal var Days = arrayListOf<String>("unsayd", "nmoyad", "suetady", "awedsendy", "daysthur", "ifrday", "tursaday")

    // internal var correctDays = arrayListOf<String>("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        answerWord = findViewById(R.id.answer)
        showWord = findViewById(R.id.word)
        enterWord = findViewById(R.id.enter_word)
        check = findViewById(R.id.check)
        change = findViewById(R.id.change)
        random = Random()



        check.setOnClickListener {
            var wordEntered = enterWord.text.toString()

            answerWord.text = wordEntered

            if (wordEntered == "Sunday") {
                Toast.makeText(this@MainActivity, "Great! You're right", Toast.LENGTH_SHORT).show()
            } else if (wordEntered == "Monday"){
                Toast.makeText(this@MainActivity, "Great! You're right", Toast.LENGTH_SHORT).show()
            } else if (wordEntered == "Tuesday") {
                Toast.makeText(this@MainActivity, "Great! You're right", Toast.LENGTH_SHORT).show()
            } else if (wordEntered == "Wednesday") {
                Toast.makeText(this@MainActivity, "Great! You're right", Toast.LENGTH_SHORT).show()
            } else if (wordEntered == "Thursday") {
                Toast.makeText(this@MainActivity, "Great! You're right", Toast.LENGTH_SHORT).show()
            } else if (wordEntered == "Friday") {
                Toast.makeText(this@MainActivity, "Great! You're right", Toast.LENGTH_SHORT).show()
            } else if (wordEntered == "Saturday") {
                Toast.makeText(this@MainActivity, "Great! You're right", Toast.LENGTH_SHORT).show()
            } else
            Toast.makeText(this@MainActivity, "You're wrong, try again!", Toast.LENGTH_SHORT).show()
        }

        // This change the days of the week randomly
        change.setOnClickListener {
            showWord.text = Days.random().toString()
        }


    }

    private fun playQuiz() {

        // This allows it to show one after the other
        day = Days[random.nextInt(Days.size)]

        answerWord.text = mixLetters(day)

    }

    // Create a function to mix letters
    // :String means it should return string value
    fun mixLetters(word: String): String {

        var words = Arrays.asList<String>(*word.split("".toRegex()).dropLastWhile ( { it.isEmpty() }).toTypedArray())

        Collections.shuffle(words)
        var mixes = ""

        for (i in words) {
            mixes += i
        }

        return mixes
    }
}
