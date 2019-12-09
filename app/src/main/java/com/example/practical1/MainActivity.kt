package com.example.practical1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.TextValueSanitizer
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var countButton: Button = findViewById(R.id.buttonCalculate)

        countButton.setOnClickListener() { calculate() }

        var resetButton: Button = findViewById(R.id.buttonReset)

        resetButton.setOnClickListener { reset() }
    }

    private fun calculate(){

        var carPrice: TextView = findViewById(R.id.editTextCarPrice)
        var downPayment: TextView = findViewById(R.id.editTextDownPayment)
        var loanPeriod: TextView = findViewById(R.id.editTextLoanPeriod)
        var interestRate: TextView = findViewById(R.id.editTextInterestRate)

        //Hi

        var totalLoan: TextView = findViewById(R.id.textViewLoan)
        var totalInterest: TextView = findViewById(R.id.textViewInterest)
        var totalMonthRepay: TextView = findViewById(R.id.textViewMonthlyRepayment)

        var carLoan: Double
        var interest: Double
        var monthlyRepay: Double

        carLoan = (carPrice.text.toString().toDouble() - downPayment.text.toString().toDouble())
        interest = (carLoan.toDouble() * interestRate.text.toString().toDouble() * loanPeriod.text.toString().toInt())
        monthlyRepay = ((carLoan * interest) / (loanPeriod.text.toString().toInt()) / 12)

        totalLoan.text = "Loan: RM" + carLoan.toString()
        totalInterest.text = "Interest: RM" + interest.toString()
        totalMonthRepay.text = "Monthly Repayment: RM" + monthlyRepay.toString()

    }

    private fun reset(){
        var carPrice: TextView = findViewById(R.id.editTextCarPrice)
        var downPayment: TextView = findViewById(R.id.editTextDownPayment)
        var loanPeriod: TextView = findViewById(R.id.editTextLoanPeriod)
        var interestRate: TextView = findViewById(R.id.editTextInterestRate)

        var totalLoan: TextView = findViewById(R.id.textViewLoan)
        var totalInterest: TextView = findViewById(R.id.textViewInterest)
        var totalMonthRepay: TextView = findViewById(R.id.textViewMonthlyRepayment)

        carPrice.text = ""
        downPayment.text = ""
        interestRate.text = ""
        loanPeriod.text = ""

        totalInterest.text = "Interest: "
        totalLoan.text = "Loan: "
        totalMonthRepay.text = "Monthly Repayment: "
    }
}
