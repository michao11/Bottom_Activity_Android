package com.example.bottomactivity.ui.contact

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.bottomactivity.R
import com.example.bottomactivity.databinding.FragmentContactBinding
import com.example.bottomactivity.databinding.FragmentDashboardBinding
import com.example.bottomactivity.ui.dashboard.DashboardViewModel

class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val contactViewModel =
            ViewModelProvider(this).get(ContactViewModel::class.java)

        _binding = FragmentContactBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView = binding.textContact
        val calendarView = binding.calendarView

        calendarView.setOnDateChangeListener { calendarView, i, i2, i3 ->
            var string = ""
            string += i.toString() + " "
            string += (i2 + 1).toString() + " "
            string += i3.toString()
            textView.text = string
        }

        val contactTextView: TextView = binding.textViewContact
        contactViewModel.text.observe(viewLifecycleOwner) {
            contactTextView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}