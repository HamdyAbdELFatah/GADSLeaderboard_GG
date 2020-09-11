package com.hamdy.gadsleaderboard.ui.leadership.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hamdy.gadsleaderboard.R
import com.hamdy.gadsleaderboard.model.LearningHourModel
import com.hamdy.gadsleaderboard.model.LearningSkillModel

class LearningSkillsAdapter : RecyclerView.Adapter<LearningSkillsAdapter.Holder>() {
    private var skills: List<LearningSkillModel>? = null
    lateinit var  myContext: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        myContext=parent.context
        val itemView: View = LayoutInflater.from(myContext)
            .inflate(R.layout.item_learn, parent, false)
        return Holder(itemView)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val leadership = skills?.get(position)
        holder.leaderName.text= leadership?.name
        holder.leaderDescription.text= "${leadership?.score} skill IQ score, ${leadership?.country}"
        Glide.with(myContext).load(leadership?.badgeUrl).into(holder.leaderImage)
    }
    override fun getItemCount(): Int {
        if(skills!=null)
            return skills!!.size
        return 0
    }
    fun setSkills(skill: List<LearningSkillModel>) {
        this.skills = skill
        notifyDataSetChanged()
    }
    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val leaderImage= itemView.findViewById<ImageView>(R.id.leaderImage)!!
        val leaderName= itemView.findViewById<TextView>(R.id.leaderName)!!
        val leaderDescription= itemView.findViewById<TextView>(R.id.leaderDescription)!!
    }
}