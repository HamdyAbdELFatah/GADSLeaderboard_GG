package com.hamdy.gadsleaderboard.network

import com.hamdy.gadsleaderboard.model.LearningHourModel
import com.hamdy.gadsleaderboard.model.LearningSkillModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiClients {

    @GET("/api/hours")
    fun getLearningHours(): Call<List<LearningHourModel>>
    @GET("/api/skilliq")
    fun getLearningSkills(): Call<List<LearningSkillModel>>

    @POST
    @FormUrlEncoded
    fun submitProject(
        @Url url: String ,
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.1824927963") emailAddress: String,
        @Field("entry.284483984") projectLink: String
    ): Response<Void>
}