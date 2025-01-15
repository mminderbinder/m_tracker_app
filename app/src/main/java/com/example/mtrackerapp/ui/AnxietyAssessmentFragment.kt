package com.example.mtrackerapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mtrackerapp.R

class AnxietyAssessmentFragment : Fragment() {
    companion object {
        fun newInstance() = AnxietyAssessmentFragment()
    }

    private val viewModel: AnxietyAssessmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_anxiety_assessment, container, false)
    }
}