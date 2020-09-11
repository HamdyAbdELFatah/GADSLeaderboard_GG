package com.hamdy.gadsleaderboard.ui.leadership
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamdy.gadsleaderboard.R
import com.hamdy.gadsleaderboard.model.LearningHourModel
import com.hamdy.gadsleaderboard.network.RetrofitInstance
import com.hamdy.gadsleaderboard.ui.leadership.adapter.LearningHourAdapter
import kotlinx.android.synthetic.main.fragment_leaders_learning_hours.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback;

class LearningHoursLeadersFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_leaders_learning_hours, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter=LearningHourAdapter()

        hoursRecyclerView.layoutManager = LinearLayoutManager(activity)
        hoursRecyclerView.adapter = adapter
        val call=RetrofitInstance.mApi.getLearningHours()
        call.enqueue(object : Callback<List<LearningHourModel>> {
            override fun onResponse(
                call: Call<List<LearningHourModel>>,
                response: Response<List<LearningHourModel>>
            ) {
                val hour = response.body()!!
                val list: ArrayList<LearningHourModel> = ArrayList()
                for (i in hour) {
                    list.add(LearningHourModel(i.name, i.hours, i.country, i.badgeUrl))
                }
                adapter.setHours(list)
            }

            override fun onFailure(call: Call<List<LearningHourModel>>, t: Throwable) {
                Toast.makeText(activity, "failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
