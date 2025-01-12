package com.example.mtrackerapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mtrackerapp.data.Assessment
import com.example.mtrackerapp.databinding.ItemAssessmentBinding

class AssessmentAdapter(private val onItemClick: (Int) -> Unit) :
    RecyclerView.Adapter<AssessmentAdapter.ViewHolder>()
{
    private val assessments = mutableListOf<Assessment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssessmentAdapter.ViewHolder
    {
        val binding =
            ItemAssessmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AssessmentAdapter.ViewHolder, position: Int)
    {
        holder.bind(assessments[position])
        holder.itemView.setOnClickListener { onItemClick(position) }
    }

    fun addAssessment(assessment: Assessment)
    {
        assessments.add(assessment)
        notifyItemInserted(assessments.size - 1)
    }

    override fun getItemCount(): Int = assessments.size

    class ViewHolder(private val binding: ItemAssessmentBinding) :
        RecyclerView.ViewHolder(binding.root)
    {
        fun bind(assessment: Assessment)
        {
            binding.apply {
                tvAssessmentTitle.text = assessment.assessmentTitle
                tvAssessmentName.text = assessment.assessmentName
                tvAssessmentDescription.text = assessment.description
            }
        }
    }
}