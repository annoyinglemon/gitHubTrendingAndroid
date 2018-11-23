package io.caster.tutorial.mobile_ui.injection.module

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.caster.tutorial.cache.ProjectsCacheImpl
import io.caster.tutorial.cache.db.ProjectsDatabase
import io.caster.tutorial.cache.mapper.CacheMapper
import io.caster.tutorial.cache.mapper.CachedProjectMapper
import io.caster.tutorial.data.repository.ProjectsCache

@Module
abstract class CacheModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesDatabase(application: Application): ProjectsDatabase {
            return ProjectsDatabase.getInstance(application)
        }
        @Provides
        @JvmStatic
        fun provideMapper() : CachedProjectMapper {
            return CachedProjectMapper()
        }
    }

    @Binds
    abstract fun bindProjectsCache(projectsCache: ProjectsCacheImpl): ProjectsCache

}