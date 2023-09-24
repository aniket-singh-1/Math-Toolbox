package com.example.gcfcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gcfcalculator.databinding.FragmentPrimeFactorizationBinding

class PrimeFactorization : Fragment() {
    private lateinit var binding: FragmentPrimeFactorizationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPrimeFactorizationBinding.inflate(inflater, container, false)

        // Set an OnClickListener for the Calculate button
        binding.calculateButton1.setOnClickListener {
            // Get user input from EditText fields
            val input1 = binding.editTextNumber1.text.toString()
            val input2 = binding.editTextNumber2.text.toString()

            // Check if both inputs are not empty
            if (input1.isNotEmpty() && input2.isNotEmpty()) {
                // Convert input strings to integers
                val number1 = input1.toInt()
                val number2 = input2.toInt()

                // Calculate the Prime Factorization
                val factors1 = calculatePrimeFactors(number1)
                val factors2 = calculatePrimeFactors(number2)

                // Display the result
                binding.resultTextView.text = "Prime Factors for Number 1: $factors1\nPrime Factors for Number 2: $factors2"
            } else {
                // Handle empty input
                binding.resultTextView.text = "Please enter valid numbers."
            }
        }
        return binding.root
    }

    companion object {
        private fun calculatePrimeFactors(number: Int): List<Int> {
            val primeFactors = mutableListOf<Int>()
            var n = number
            var divisor = 2

            while (n > 1) {
                if (n % divisor == 0) {
                    primeFactors.add(divisor)
                    n /= divisor
                } else {
                    divisor++
                }
            }

            return primeFactors

        }
    }
}

