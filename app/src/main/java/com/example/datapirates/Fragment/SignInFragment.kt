package com.example.datapirates.Fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.datapirates.Activity.MainActivity
import com.example.datapirates.SQLDatabase.SqliteDatabase
import com.example.datapirates.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignInBinding.inflate(layoutInflater)
        sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        if (isLoggedIn()) {
            startMainActivity()
        }

        val db = SqliteDatabase(requireContext())
        val list = db.showData()

        binding.btnSignIn.setOnClickListener {

            val email = binding.edtEmail.text.toString()
            val pass = binding.edtPass.text.toString()

            var flag = false

            for (i in 0 until list.size) {
                if (list[i].email == email && list[i].password == pass) {
                    flag = true
                    break
                }
            }

            if (flag) {
                saveLoginState(true)
                Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                startMainActivity()
            } else {
                Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    private fun saveLoginState(isLoggedIn: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", isLoggedIn)
        editor.apply()
    }

    private fun startMainActivity() {
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }
}
