package io.caster.tutorial.domain.interactor.bookmark

import io.caster.tutorial.domain.executor.PostExecutionThread
import io.caster.tutorial.domain.interactor.ObservableUseCase
import io.caster.tutorial.domain.model.Project
import io.caster.tutorial.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetBookmarkedProjects @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    postExecutionThread: PostExecutionThread) :
    ObservableUseCase<List<Project>, Nothing?>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectsRepository.getBookmarkedProjects()
    }

}