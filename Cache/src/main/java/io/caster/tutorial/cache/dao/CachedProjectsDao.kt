package io.caster.tutorial.cache.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.caster.tutorial.cache.db.ProjectConstants.DELETE_PROJECTS
import io.caster.tutorial.cache.db.ProjectConstants.QUERY_BOOKMARKED_PROJECTS
import io.caster.tutorial.cache.db.ProjectConstants.QUERY_PROJECTS
import io.caster.tutorial.cache.db.ProjectConstants.QUER_UPDATE_BOOKMARK_STATUS
import io.caster.tutorial.cache.model.CachedProject
import io.reactivex.Flowable

@Dao
abstract class CachedProjectsDao {

    @Query(QUERY_PROJECTS)
    abstract fun getProjects(): Flowable<List<CachedProject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertProjects(projects: List<CachedProject>)

    @Query(DELETE_PROJECTS)
    abstract fun deleteProjects()

    @Query(QUERY_BOOKMARKED_PROJECTS)
    abstract fun getBookmarkedProjects(): Flowable<List<CachedProject>>

    @Query(QUER_UPDATE_BOOKMARK_STATUS)
    abstract fun setBookmarkStatus(isBookmarked: Boolean, projectId: String)

}
