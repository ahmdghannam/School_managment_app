package fts.ahmed.school.view.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import fts.ahmed.school.databinding.RvItemBinding
import fts.ahmed.school.model.models.Student

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {

            binding.apply {
                tvName.text = "name : "+student.name
                tvDob.text = "date of birth : "+student.dateOfBirth
                tvId.text = "id : "+student.id
                tvMajor.text = "major : "+student.major
            }

        }
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<Student>() {
        override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, diffCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = differ.currentList[position]
        holder.bind(student)

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}