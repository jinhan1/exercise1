package com.example.excercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCal.setOnClickListener{
            var filled=true
            if(editTextCarPrice.length()==0) {
                editTextCarPrice.setError("Please enter car price!")
                filled = false
            }
            if(editTextDownPayment.length()==0) {
                editTextDownPayment.setError("Enter the down payment!")
                filled = false
            }
            if(editTextLoanPeriod.length()==0) {
                editTextLoanPeriod.setError("Enter the loan period!")
                filled = false
            }
            if(editTextInterestRate.length()==0) {
                editTextInterestRate.setError("Enter the interest rate!")
                filled = false
            }

            if(filled==true){
                val car_price=editTextCarPrice.text.toString().toInt()
                val down_payment=editTextDownPayment.text.toString().toInt()
                val loan_period=editTextLoanPeriod.text.toString().toInt()
                val interest_rate=editTextInterestRate.text.toString().toDouble()

                val loan=car_price-down_payment
                textViewLoan.text=getString(R.string.loan)+  loan.toString()
                val interest=loan*(interest_rate/100)*loan_period
                textViewInterest.text=getString(R.string.interest)+ interest.toString()
                val monthlyPayment=(loan+interest)/loan_period/12
                textViewMonthlyPayment.text=getString(R.string.monthly_payment)+ monthlyPayment.toString()
            }

        }

    }

    fun resetInputs(view: View) {
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextLoanPeriod.setText("")
        editTextInterestRate.setText("")
        textViewLoan.setText(getString(R.string.loan))
        textViewInterest.setText(getString(R.string.interest))
        textViewMonthlyPayment.setText(getString(R.string.monthly_payment))
    }

}
