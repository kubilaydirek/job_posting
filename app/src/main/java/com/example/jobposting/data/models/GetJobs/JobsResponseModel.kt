package com.example.jobposting.data.models.getjobs


data class JobsResponseModel(
    val category: String?,
    val companyName: String?,
    val createdDate: String?,
    val description: String?,
    val experienceYears: Int?,
    val expiryDate: String?,
    val id: Int?,
    val location: String?,
    val requirements: String?,
    val salaryRange: String?,
    val status: String?,
    val title: String?,
    val user: User?
) {
    data class User(
        val id: Int?
    )
}

