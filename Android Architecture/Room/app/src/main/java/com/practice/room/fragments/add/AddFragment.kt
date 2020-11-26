package com.practice.room.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.practice.room.R
import com.practice.room.model.User
import com.practice.room.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {
private  lateinit var mUserViewModel : UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.button.setOnClickListener{
            insertDataToDatabase()
        }

        return  view
    }

    private fun insertDataToDatabase() {
        val firstName= editTextFirstName.text.toString();
        val lastName = editTextSurname.text.toString();
        val age = editTextAge.text

        if(inputCheck(firstName,lastName,age)){
            //Tworzenie user
            val user = User(0,firstName,lastName,Integer.parseInt(age.toString()))

            //Add data to db
            mUserViewModel.addUser(user)

            //Zamiast this , bedzie requireContext bo tu nma
            Toast.makeText(requireContext(), firstName+", "+lastName+", "+age, Toast.LENGTH_LONG).show()


            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
    }
// : Boolean oznacza ze zwracam boolean
    //Editable
    private fun inputCheck(firstName : String, lastName:String , age: Editable): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(firstName) &&  age.isEmpty())
    }


}