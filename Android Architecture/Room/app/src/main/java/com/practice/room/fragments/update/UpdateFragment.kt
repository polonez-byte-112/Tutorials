package com.practice.room.fragments.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.practice.room.R
import com.practice.room.model.User
import com.practice.room.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private  val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel : UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)


        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)



        view.editTextFirstName2.setText(args.currentUser.firstName)
        view.editTextSurname2.setText(args.currentUser.secondName)
        view.editTextAge2.setText(args.currentUser.age.toString())


        view.button2.setOnClickListener {
            updateItem()
        }

        //Add menu
        setHasOptionsMenu(true)

        //Dokoczyc  (1:40)

        return view
    }


    private fun updateItem(){
        val firstNamee = editTextFirstName2.text.toString()
        val secondNamee = editTextSurname2.text.toString()
        val agee = Integer.parseInt(editTextAge2.text.toString())

        if(inputCheck(firstNamee,secondNamee,editTextAge2.text)){
//Create user object

            val updatedUser = User(args.currentUser.id, firstNamee, secondNamee, agee)

            //Update

            mUserViewModel.updateUser(updatedUser)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
            //Navigate back

            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }


    private fun inputCheck(firstName : String, lastName:String , age: Editable): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(firstName) &&  age.isEmpty())
    }





}