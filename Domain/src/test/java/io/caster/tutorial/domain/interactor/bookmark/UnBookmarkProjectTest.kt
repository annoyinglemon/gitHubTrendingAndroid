package io.caster.tutorial.domain.interactor.bookmark

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import io.caster.tutorial.domain.executor.PostExecutionThread
import io.caster.tutorial.domain.repository.ProjectsRepository
import io.caster.tutorial.domain.test.ProjectDataFactory
import io.reactivex.Completable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.lang.IllegalArgumentException

class UnBookmarkProjectTest {

    private lateinit var unBookmarkProject: UnbookmarkProject
    @Mock
    lateinit var projectsRepository: ProjectsRepository
    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        unBookmarkProject = UnbookmarkProject(projectsRepository, postExecutionThread)
    }

    @Test
    fun unBookmarkProjectCompletes() {
        stubUnBookmarkProject(Completable.complete())
        val testObserver = unBookmarkProject.buildUseCaseCompletable(
            UnbookmarkProject.Params.forProject(ProjectDataFactory.randomUuid())).test()
        testObserver.assertComplete()
    }

    @Test(expected = IllegalArgumentException::class)
    fun unBookmarkProjectThrowsException() {
        unBookmarkProject.buildUseCaseCompletable().test()
    }

    private fun stubUnBookmarkProject(completable: Completable) {
        whenever(projectsRepository.unBookmarkProject(any()))
            .thenReturn(completable)
    }

}