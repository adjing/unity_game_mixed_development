package com.gameforce.unitycomposeui2022

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//ViewModel Fragment
class UnityAFragment : Fragment() {

    companion object {
        fun newInstance() = UnityAFragment()
    }

    private lateinit var viewModel: UnityAViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_unity_a, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UnityAViewModel::class.java)
        // TODO: Use the ViewModel
    }

}