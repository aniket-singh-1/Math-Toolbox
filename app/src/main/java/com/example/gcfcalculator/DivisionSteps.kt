package com.example.gcfcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gcfcalculator.databinding.FragmentDivisionStepsBinding

class DivisionSteps : Fragment() {
    private lateinit var binding: FragmentDivisionStepsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDivisionStepsBinding.inflate(inflater, container, false)

        // Set an OnClickListener for the Calculate button
        binding.calculateButton3.setOnClickListener {
            // Get user input from EditText fields
            val input1 = binding.editTextNumber5.text.toString()
            val input2 = binding.editTextNumber6.text.toString()

            // Check if both inputs are not empty
            if (input1.isNotEmpty() && input2.isNotEmpty()) {
                // Convert input strings to integers
                val number1 = input1.toInt()
                val number2 = input2.toInt()

                // Calculate the List of Factors
                val divisionSteps = calculateDivisionSteps(number1, number2)

                // Display the result
                binding.resultTextView.text = "Division Steps: $divisionSteps"
            } else {
                // Handle empty input
                binding.resultTextView.text = "Please enter valid numbers."
            }
        }
        return binding.root
    }

    companion object {
        // Function to perform division and return the steps involved
        fun calculateDivisionSteps(dividend: Int, divisor: Int): List<String> {
            val steps = mutableListOf<String>() // List to store the steps
            // Check if the divisor is 0, which would result in an error
            if (divisor == 0) {
                steps.add("Division by 0 is undefined.")
                return steps
            }
            var quotient = dividend / divisor // Calculate the quotient
            var remainder = dividend % divisor // Calculate the remainder
            // Add the initial division step to the list
            steps.add("$dividend / $divisor = $quotient remainder $remainder")
            // While the remainder is not 0, continue the division process
            while (remainder != 0) {
                // Multiply the divisor by the quotient to get the next dividend
                val nextDividend = divisor * quotient
                // Subtract the next dividend from the current dividend to get the next remainder
                remainder = dividend - nextDividend
                // Calculate the next quotient
                quotient = remainder / divisor
                // Add the next division step to the list
                steps.add("$nextDividend / $divisor = $quotient remainder $remainder")
            }

            return steps // Return the list of steps
        }
    }
}
