package com.example.gcfcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gcfcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //setContentView(R.layout.activity_main)

        // Set an OnClickListener for the Calculate button
        binding.btnCalculate.setOnClickListener {
            // Get user input from EditText fields
            val input1 = binding.editTextNumber1.text.toString()
            val input2 = binding.editTextNumber2.text.toString()

            // Check if both inputs are not empty
            if (input1.isNotEmpty() && input2.isNotEmpty()) {
                // Convert input strings to integers
                val number1 = input1.toInt()
                val number2 = input2.toInt()

                // Calculate the GCF
                val gcf = calculateGCF(number1, number2)

                // Display the result
                binding.textViewResult.text = "GCF: $gcf"
            } else {
                // Handle empty input
                binding.textViewResult.text = "Please enter valid numbers."
            }
        }
        binding.button2.setOnClickListener {
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.Frame, ListOfFactors())
            transaction.commit()
        }
        binding.button1.setOnClickListener {
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.Frame, PrimeFactorization())
            transaction.commit()
        }
        binding.button3.setOnClickListener {
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.Frame, DivisionSteps())
            transaction.commit()
        }

    }


    }

    // Function to calculate the Greatest Common Factor (GCF)
    private fun calculateGCF(a: Int, b: Int): Int {
        return if (b == 0) a else calculateGCF(b, a % b)
    }




