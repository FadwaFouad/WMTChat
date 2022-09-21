package com.tech4dev.wmtchat.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.tech4dev.wmtchat.R

class CallFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_call, container, false)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.call_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}