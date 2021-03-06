package com.practice.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    /**
     * Kolejnosc
     * 1.OnCreate
     * 2.OnCreateView
     * 3.onViewCreated
     */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // dwa sposoby
        // jeden to ten ponizej a drugi to podajemy R.layout.fragment_blank w parametrze rozszerzanej klasy Fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // onCreateView dzieje sie po onCreate przez co nie mamy dostepu do zmiennych
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //tutaj mamy dostep do zmiennych bo to sie dzieje po onCreateView
    }

}