package io.caster.tutorial.cache.test.factory

import io.caster.tutorial.cache.model.CachedProject
import io.caster.tutorial.data.model.ProjectEntity

object ProjectDataFactory {

    fun makeCachedProject() : CachedProject {
        return CachedProject(DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString(),
            false)
    }

    fun makeProjectEntity() : ProjectEntity {
        return ProjectEntity(DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomBoolean())
    }

    fun makeBookmarkedCachedProject() : CachedProject {
        return CachedProject(DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString(),
            true)
    }

}