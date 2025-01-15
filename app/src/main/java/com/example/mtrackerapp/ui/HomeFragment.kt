package com.example.mtrackerapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mtrackerapp.R
import com.example.mtrackerapp.data.models.Assessment
import com.example.mtrackerapp.databinding.FragmentHomeBinding
import com.google.android.material.transition.MaterialElevationScale

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: AssessmentAdapter

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        addAssessments()
    }

    private fun setUpRecyclerView() {
        adapter = AssessmentAdapter { view, assessment ->

            exitTransition = MaterialElevationScale(false).apply {
                duration =
                    resources.getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)
                        .toLong()
            }
            reenterTransition = MaterialElevationScale(true).apply {
                duration =
                    resources.getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)
                        .toLong()
            }
            val assessmentCardDetailsTransitionName =
                getString(R.string.assessment_card_detail_transition_name)
            val extras = FragmentNavigatorExtras(view to assessmentCardDetailsTransitionName)

            val directions = HomeFragmentDirections
                .actionHomeToAssessmentDetail(assessment.assessmentId)
            findNavController().navigate(directions, extras)
        }
        binding.rvAssessmentList.apply {
            this.adapter = this@HomeFragment.adapter
            layoutManager = LinearLayoutManager(context)
            isTransitionGroup = true
        }
    }

    private fun addAssessments() {
        adapter.addAssessment(
            Assessment(
                assessmentId = 12500,
                assessmentTitle = "GAD-7",
                assessmentName = "Generalized Anxiety Disorder 7",
                description = "Lorem ipsum dolor sit amet...",
            )
        )
        adapter.addAssessment(
            Assessment(
                assessmentId = 12501,
                assessmentTitle = "PHQ-9",
                assessmentName = "Patient Health Questionnaire",
                description = "Lorem ipsum dolor sit amet..."
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}