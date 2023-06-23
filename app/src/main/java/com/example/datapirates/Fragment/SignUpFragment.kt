package com.example.datapirates.Fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.datapirates.Activity.MainActivity
import com.example.datapirates.SQLDatabase.SqliteDatabase
import com.example.datapirates.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {


    lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignUpBinding.inflate(layoutInflater)
        var db1 = SqliteDatabase(context)

        var list1 = db1.showData()

        binding.btnSignUp.setOnClickListener {

            var fname = binding.edtFname.text.toString()
            var lname = binding.edtLname.text.toString()
            var email = binding.edtEmail.text.toString()
            var pass = binding.edtPassword.text.toString()
            var cPass = binding.edtConfirmPass.text.toString()

            if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || pass.isEmpty() || cPass.isEmpty()) {
                Toast.makeText(context, "Please fill full Detail", Toast.LENGTH_SHORT).show()
            } else {
                if (cPass != pass) {
                    binding.edtConfirmPass.setError("password does not match")
                } else {
                    db1.AddData(fname, lname, email, pass, cPass)
                    Toast.makeText(context, "Sign up success!!", Toast.LENGTH_SHORT).show()


                }
            }

        }

        return binding.root
    }

}