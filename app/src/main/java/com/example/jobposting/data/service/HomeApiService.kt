package com.example.jobposting.data.service

import com.example.jobposting.data.models.getjobs.JobsResponseModel
import retrofit2.http.GET

interface HomeApiService {

    @GET("job-postings")
    suspend fun getAllJobs(): List<JobsResponseModel>?
}