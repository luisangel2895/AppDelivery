package io.saphi.delivery.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

import io.saphi.delivery.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivHomeFragmentFood.setOnClickListener {
            val bundle = bundleOf("type" to "food")
            findNavController().navigate(R.id.shopsFragment, bundle)
        }
        ivHomeFragmentTecnology.setOnClickListener {
            val bundle = bundleOf("type" to "tecnology")
            findNavController().navigate(R.id.shopsFragment, bundle)
        }
        ivHomeFragmentEconomy.setOnClickListener {
            val bundle = bundleOf("type" to "economy")
            findNavController().navigate(R.id.shopsFragment, bundle)
        }
        ivHomeFragmentMayorism.setOnClickListener {
            val bundle = bundleOf("type" to "mayorism")
            findNavController().navigate(R.id.shopsFragment, bundle)
        }
        ivHomeFragmentMinorism.setOnClickListener {
            val bundle = bundleOf("type" to "minorism")
            findNavController().navigate(R.id.shopsFragment, bundle)
        }

    }

}
