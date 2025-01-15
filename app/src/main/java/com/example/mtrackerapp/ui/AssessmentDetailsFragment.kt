package com.example.mtrackerapp.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.mtrackerapp.R
import com.example.mtrackerapp.databinding.FragmentAssessmentDetailsBinding
import com.google.android.material.transition.MaterialContainerTransform

class AssessmentDetailsFragment : Fragment() {
    private var _binding: FragmentAssessmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AssessmentDetailsViewModel by viewModels()

    private val args by navArgs<AssessmentDetailsFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_host_fragment
            duration =
                resources.getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)
                    .toLong()
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(requireContext().getColor(R.color.md_theme_surface))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAssessmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}