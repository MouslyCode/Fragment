package com.example.myfragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText


class Fragment_first : Fragment() {
    private var communicationViewModel: CommunicationViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communicationViewModel =
          ViewModelProviders.of(requireActivity()).
                  get(CommunicationViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameEditText = view.findViewById<TextInputEditText>(R.id.textInputTextName)
        nameEditText.addTextChangedListener(
            object : TextWatcher{
                override fun beforeTextChanged(charSequence: CharSequence, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(charSequence:CharSequence, p1: Int, p2: Int, p3: Int) {
                    communicationViewModel!!.setName(charSequence.toString())
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            }
        )
    }

    companion object {
    fun  newInstance():Fragment_first{
        return Fragment_first()
    }
    }
}