package io.caster.tutorial.cache

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import io.caster.tutorial.cache.db.ProjectsDatabase
import io.caster.tutorial.cache.mapper.CachedProjectMapper
import io.caster.tutorial.cache.test.factory.ProjectDataFactory
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment


@RunWith(RobolectricTestRunner::class)
class ProjectsCacheImplTest {

    @get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val database = Room.inMemoryDatabaseBuilder(
        RuntimeEnvironment.application.applicationContext,
        ProjectsDatabase::class.java)
        .allowMainThreadQueries()
        .build()
    private val entityMapper = CachedProjectMapper()
    private val cache = ProjectsCacheImpl(database, entityMapper)

    @Test
    fun clearTablesCompletes() {
        val testObserver = cache.clearProjects().test()
        testObserver.assertComplete()
    }

    @Test
    fun saveProjectsCompletes() {
        val projects = listOf(ProjectDataFactory.makeProjectEntity())

        val testObserver = cache.saveProjects(projects).test()
        testObserver.assertComplete()
    }

    @Test
    fun getProjectsReturnData() {
        val projects = listOf(ProjectDataFactory.makeProjectEntity())
        cache.saveProjects(projects).test()

        val testObserver = cache.getProjects().test()
        testObserver.assertValue(projects)
    }

    @Test
    fun getBookmarkedProjectsReturnData() {
        val bookmarkProject = ProjectDataFactory.makeBookmarkedProjectEntity()
        val projects = listOf(ProjectDataFactory.makeProjectEntity(), bookmarkProject)

        cache.saveProjects(projects).test()

        val testObserver = cache.getBookmarkedProjects().test()
        testObserver.assertValue(listOf(bookmarkProject))
    }

    @Test
    fun setProjectAsBookmarkedCompletes() {
        val projects = listOf(ProjectDataFactory.makeProjectEntity())
        cache.saveProjects(projects)

        val testObserver = cache.setProjectAsBookmarked(projects[0].id).test()
        testObserver.assertComplete()
    }

    @Test
    fun setProjectAsNotBookmarkedCompletes() {
        val projects = listOf(ProjectDataFactory.makeProjectEntity())
        cache.saveProjects(projects)

        val testObserver = cache.setProjectAsNotBookmarked(projects[0].id).test()
        testObserver.assertComplete()
    }

    @Test
    fun areProjectsCacheReturnsData() {
        val projects = listOf(ProjectDataFactory.makeProjectEntity())
        cache.saveProjects(projects)

        val testObserver = cache.areProjectsCached().test()
        testObserver.assertValue(true)
    }

    @Test
    fun setLastCacheTimeCompletes() {
        val testObserver = cache.setLastCacheTime(1000L).test()
        testObserver.assertComplete()
    }

    @Test
    fun isProjectsCacheExpiredReturnsExpired() {
        val testObserver = cache.isProjectsCacheExpired().test()
        testObserver.assertValue(true)
    }

    @Test
    fun isProjectsCacheExpiredReturnsNotExpired() {
        cache.setLastCacheTime(System.currentTimeMillis()).test()
        val testObserver = cache.isProjectsCacheExpired().test()
        testObserver.assertValue(false)
    }

}