package io.caster.tutorial.remote.service

import io.caster.tutorial.remote.model.ProjectsResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubTrendingService {

    @GET("search/repositories")
    fun searchRepositories(@Query("q") query: String,
                           @Query("sort") sortBy: String,
                           @Query("order") order: String)
    : Observable<ProjectsResponseModel>

}