package io.caster.tutorial.domain.interactor.bookmark

import io.caster.tutorial.domain.executor.PostExecutionThread
import io.caster.tutorial.domain.interactor.CompletableUseCase
import io.caster.tutorial.domain.repository.ProjectsRepository
import io.reactivex.Completable
import java.lang.IllegalArgumentException
import javax.inject.Inject

class BookmarkProject @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    postExecutionThread: PostExecutionThread) :
    CompletableUseCase<BookmarkProject.Params>(postExecutionThread) {

    override
    fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params cannot be null!")
        return projectsRepository.bookmarkProject(params.projectId)
    }

    data class Params constructor(val projectId: String) {
        companion object {
            fun forProject(projectId: String): Params {
                return Params(projectId)
            }
        }
    }

}