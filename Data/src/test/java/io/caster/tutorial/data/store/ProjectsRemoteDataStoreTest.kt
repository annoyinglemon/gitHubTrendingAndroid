package io.caster.tutorial.data.store

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.caster.tutorial.data.model.ProjectEntity
import io.caster.tutorial.data.repository.ProjectsRemote
import io.caster.tutorial.data.test.factory.DataFactory
import io.caster.tutorial.data.test.factory.ProjectFactory
import io.reactivex.Observable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ProjectsRemoteDataStoreTest {

    private val remote = mock<ProjectsRemote>()
    private val store = ProjectsRemoteDataStore(remote)

    @Test
    fun getProjectsCompletes() {
        stubRemoteGetProjects(Observable.just(listOf(ProjectFactory.makeProjectEntity())))
        val testObserver = store.getProjects().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProjectsReturnsData() {
        val projectData = listOf(ProjectFactory.makeProjectEntity())
        stubRemoteGetProjects(Observable.just(projectData))
        val testObserver = store.getProjects().test()
        testObserver.assertValue(projectData)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun getBookmarkedProjectsThrowsException() {
        store.getBookmarkedProjects().test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun setProjectAsBookmarkedThrowsException() {
        store.setProjectAsBookmarked(DataFactory.randomString()).test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun setProjectAsNotBookmarkedThrowsException() {
        store.setProjectAsNotBookmarked(DataFactory.randomString()).test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun saveProjectsThrowsException() {
        store.saveProjects(listOf(ProjectFactory.makeProjectEntity())).test()
    }

    private fun stubRemoteGetProjects(observable: Observable<List<ProjectEntity>>) {
        whenever(remote.getProjects())
            .thenReturn(observable)
    }

}