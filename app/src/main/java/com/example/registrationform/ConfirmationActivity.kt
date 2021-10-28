package com.example.registrationform

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrationform.databinding.ActivityConfirmationBinding

class ConfirmationActivity : AppCompatActivity() {

    private lateinit var registrationDetails: RegistrationDetails
    private lateinit var confirmationDataString: String
    private lateinit var binding: ActivityConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayMessage()
        setupSendMessageButtons()
    }

    private fun setupSendMessageButtons() {
        binding.textViewEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${registrationDetails.email}")
                putExtra(Intent.EXTRA_SUBJECT, "Confirmation");
                putExtra(Intent.EXTRA_TEXT, confirmationDataString);
            }
            startActivity(intent)
        }
        binding.textViewSms.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:${registrationDetails.number}")
                putExtra("sms_body", confirmationDataString)
            }
            startActivity(intent)
        }
    }

    private fun displayMessage() {
        registrationDetails = intent.getSerializableExtra("RegistrationDetails") as RegistrationDetails
        confirmationDataString = """
            Your account details:
            First name:${registrationDetails.firstName}
            Last name:${registrationDetails.lastName}
            Citizenship:${registrationDetails.citizenship}
        """.trimIndent()
        val phoneText = "Phone: ${registrationDetails.number}"
        val emailText = "Email: ${registrationDetails.email}"
        binding.textViewEmail.text = emailText
        binding.textViewSms.text = phoneText
        binding.textViewConfirmationDetails.text = confirmationDataString
    }
}