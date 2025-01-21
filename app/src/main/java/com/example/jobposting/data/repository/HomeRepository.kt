package com.example.jobposting.data.repository

import com.example.jobposting.data.helpers.Resource
import com.example.jobposting.data.models.getjobs.JobsResponseModel
import com.example.jobposting.data.service.HomeApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface HomeRepository {
    suspend fun getAllJobs(): Flow<Resource<List<JobsResponseModel>>>
}

class HomeRepositoryImp @Inject constructor(private val service: HomeApiService) : HomeRepository {
    override suspend fun getAllJobs(): Flow<Resource<List<JobsResponseModel>>> =
        flow { emit(Resource.Success(service.getAllJobs() ?: emptyList())) }
}