package io.caster.tutorial.remote

import io.caster.tutorial.data.model.ProjectEntity
import io.caster.tutorial.data.repository.ProjectsRemote
import io.caster.tutorial.remote.mapper.ProjectResponseModelMapper
import io.caster.tutorial.remote.service.GitHubTrendingService
import io.reactivex.Observable
import javax.inject.Inject

class ProjectsRemoteImpl @Inject constructor(
        private val service: GitHubTrendingService,
        private val mapper: ProjectResponseModelMapper
): ProjectsRemote {

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return service.searchRepositories("language:kotlin", "stars", "desc")
            .map {
                it.items.map {
                    mapper.mapFromModel(it)
                }
            }
    }

}