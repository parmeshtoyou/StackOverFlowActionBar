package com.param.stackoverflow


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.param.stackoverflow.listener.ActionListener

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    lateinit var listener: ActionListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as MainActivity
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener.onAction(MainActivity.ACTION_UPDATE_BAR)
    }
}
