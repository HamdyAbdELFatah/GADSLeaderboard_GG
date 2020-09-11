package com.hamdy.gadsleaderboard.ui.leadership
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamdy.gadsleaderboard.R
import com.hamdy.gadsleaderboard.model.LearningSkillModel
import com.hamdy.gadsleaderboard.network.RetrofitInstance
import com.hamdy.gadsleaderboard.ui.leadership.adapter.LearningSkillsAdapter
import kotlinx.android.synthetic.main.fragment_leaders_skill_iq.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LearningSkillIqLeadersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_leaders_skill_iq, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter= LearningSkillsAdapter()

        iqRecyclerView.layoutManager = LinearLayoutManager(activity)
        iqRecyclerView.adapter = adapter
        val call= RetrofitInstance.mApi.getLearningSkills()
        call.enqueue(object : Callback<List<LearningSkillModel>> {
            override fun onResponse(
                call: Call<List<LearningSkillModel>>,
                response: Response<List<LearningSkillModel>>
            ) {
                val hour = response.body()!!
                val list: ArrayList<LearningSkillModel> = ArrayList()
                for (i in hour) {
                    list.add(LearningSkillModel(i.name, i.score, i.country, i.badgeUrl))
                }
                adapter.setSkills(list)
            }

            override fun onFailure(call: Call<List<LearningSkillModel>>, t: Throwable) {
                Toast.makeText(activity, "failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}