package io.saphi.delivery.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import io.saphi.delivery.R
import kotlinx.android.synthetic.main.fragment_choose_register.*
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class ChooseRegisterFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvChooseFragmentNumber.setOnClickListener {
            findNavController().navigate(R.id.numberRegisterFragment)
        }
        tvChooseFragmentEmail.setOnClickListener {
            findNavController().navigate(R.id.emailRegisterFragment)
        }

    }

}
