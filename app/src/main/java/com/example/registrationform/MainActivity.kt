package com.example.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.registrationform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonRegister.setOnClickListener {
            onRegisterClicked(binding)
        }
        val spinnerValues = arrayOf("Russia", "Ukraine", "Belarus")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        binding.spinnerCitizenship.adapter = spinnerAdapter
    }

    private fun onRegisterClicked(binding: ActivityMainBinding) {
        val details = RegistrationDetails(
            binding.editTextName.text.toString(),
            binding.editTextSurname.text.toString(),
            binding.editTextEmail.text.toString(),
            binding.editTextNumber.text.toString(),
            binding.checkboxSubscribe.isChecked,
            binding.spinnerCitizenship.selectedItem.toString()
        )
        val confirmationActivityPreview = Intent(this, ConfirmationActivity::class.java)
        confirmationActivityPreview.putExtra("RegistrationDetails", details)
        startActivity(confirmationActivityPreview)
    }
}