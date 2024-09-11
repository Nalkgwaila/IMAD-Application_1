package com.example.imadapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
     private val historicalFigures = listOf(
        "Nelson Mandela" to  "95",
        "Albert Einstein" to "76" ,
        "Marie Curie" to  "66",
        "Charles Darwin" to "73",
        "William Shakespeare" to "52" ,
        "Leonardo da Vinci" to  "67",
        "Martin Luther King Jr." to "39",
        "Mahatma Gandhi" to "78",
        "Florence Nightingale" to "90",
         "Vincent van Gogh" to "37",

        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generateHistoryButton = findViewById<Button>(R.id.Button)  // button to generate the historical figure ages.
        val clearButton = findViewById<Button>(R.id.Button3) // button to clear the textview
        val closeButton = findViewById<Button>(R.id.Button2) // button to close the age
        val editText = findViewById<EditText>(R.id.EditText) // edit text to enter the age
        val resultTextView = findViewById<TextView>(R.id.textView) // view where all the results will appear

         //Set click listener for the compare button
         generateHistoryButton.setOnClickListener{
            val ageInput = editText.text.toString()
            val userAge = ageInput.toIntOrNull() // get integer

             // check if the input is valid
            if (ageInput.isBlank()) {
                resultTextView.text = "Please enter your age"
                return@setOnClickListener
            }
            if (userAge == null) {
                resultTextView. text = " Invalid input. Please enter a valid whole number."

            }else if (userAge < 20) {
                resultTextView.text = " age is too low . please enter the age between 20 and 100"
            }else if (userAge > 100) {
                resultTextView . text = "Age is too high. Please enter the age between 20 and 100"
            }else{
                if (userAge != null && userAge > 0) {

                    val matchingFigures = historicalFigures.filter {it.second.toIntOrNull()==userAge}

                    //Display the result
                    val resultText = if (matchingFigures.isNotEmpty()) {
                        "Historical Famous Person who passed away at your age"
                        matchingFigures.joinToString (separator = "\n")
                    }else{
                        "No Historical Famous Person died"
                    }
                    resultTextView.text = resultText


                }else resultTextView.text = "Please enter a positive number for your age."
            }
            clearButton.setOnClickListener{
                // Clear input field and result text view
                editText.text.clear() //Clear the age input field
                resultTextView.text = "" // Clear the result text view
            }


        }
    }
}
