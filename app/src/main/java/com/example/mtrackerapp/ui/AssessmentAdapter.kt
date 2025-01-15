package com.example.mtrackerapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mtrackerapp.data.models.Assessment
import com.example.mtrackerapp.databinding.ItemAssessmentBinding

class AssessmentAdapter(private val onItemClick: (View, Assessment) -> Unit) :
    RecyclerView.Adapter<AssessmentAdapter.ViewHolder>() {
    private val assessments = mutableListOf<Assessment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemAssessmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(assessments[position])
    }

    fun addAssessment(assessment: Assessment) {
        assessments.add(assessment)
        notifyItemInserted(assessments.size - 1)
    }

    override fun getItemCount(): Int = assessments.size

    class ViewHolder(
        private val binding: ItemAssessmentBinding,
        private val onItemClick: (View, Assessment) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(assessment: Assessment) {
            binding.apply {
                assessmentCard.transitionName = "assessment_card_${assessment.assessmentId}"

                tvAssessmentTitle.text = assessment.assessmentTitle
                tvAssessmentName.text = assessment.assessmentName
                tvAssessmentDescription.text = assessment.description

                assessmentCard.setOnClickListener { view ->
                    onItemClick(view, assessment)
                }
            }
        }
    }
}