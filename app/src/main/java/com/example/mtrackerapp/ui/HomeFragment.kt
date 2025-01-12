package com.example.mtrackerapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mtrackerapp.data.Assessment
import com.example.mtrackerapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment()
{
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: AssessmentAdapter

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        addAssessments()

    }

    private fun setUpRecyclerView()
    {
        adapter = AssessmentAdapter { position ->
            when (position)
            {
                // TODO: Add assessment navigation
            }
        }
        binding.rvAssessmentList.apply {
            this.adapter = this@HomeFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun addAssessments()
    {
        adapter.addAssessment(
            Assessment(
                assessmentTitle = "GAD-7",
                assessmentName = "Generalized Anxiety Disorder 7",
                description = "Lorem ipsum dolor sit amet...",
            )
        )
        adapter.addAssessment(
            Assessment(
                assessmentTitle = "PHQ-9",
                assessmentName = "Patient Health Questionnaire",
                description = "Lorem ipsum dolor sit amet..."
            )
        )
    }


    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }
}