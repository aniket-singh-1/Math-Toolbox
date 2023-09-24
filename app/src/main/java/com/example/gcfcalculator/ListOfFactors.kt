package com.example.gcfcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gcfcalculator.databinding.FragmentListOfFactorsBinding


class ListOfFactors() : Fragment() {
    private lateinit var binding: FragmentListOfFactorsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListOfFactorsBinding.inflate(inflater, container, false)

        // Set an OnClickListener for the Calculate button
        binding.calculateButton2.setOnClickListener {
            // Get user input from EditText fields
            val input1 = binding.editTextNumber3.text.toString()
            val input2 = binding.editTextNumber4.text.toString()

            // Check if both inputs are not empty
            if (input1.isNotEmpty() && input2.isNotEmpty()) {
                // Convert input strings to integers
                val number1 = input1.toInt()
                val number2 = input2.toInt()

                // Calculate the List of Factors
                val factors1 = calculateFactors(number1)
                val factors2 = calculateFactors(number2)

                // Display the result
                binding.resultTextView.text = "Factors for Number 1: $factors1\nFactors for Number 2: $factors2"
            } else {
                // Handle empty input
                binding.resultTextView.text = "Please enter valid numbers."
            }
        }
            return binding.root
        }

        companion object {
            private fun calculateFactors(number: Int): List<Int> {
                val factors = mutableListOf<Int>()
                for (i in 1..number) {
                    if (number % i == 0) {
                        factors.add(i)
                    }
                }
                return factors
            }
        }
    }


