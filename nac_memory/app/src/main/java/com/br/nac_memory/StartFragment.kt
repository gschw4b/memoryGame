package com.br.nac_memory

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.br.nac_memory.data.ASSharedPreferences
import com.br.nac_memory.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var sharedPrefs: ASSharedPreferences
    private lateinit var bindings: FragmentStartBinding
    private lateinit var player: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPrefs = ASSharedPreferences(context)
        player = sharedPrefs.getPlayer().toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindings = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)
        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        bindings.next.setOnClickListener {
            view.findNavController().navigate(R.id.action_startFragment_to_gameActivity)
        }
    }

}