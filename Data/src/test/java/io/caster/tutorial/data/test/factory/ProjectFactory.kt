package io.caster.tutorial.data.test.factory

import io.caster.tutorial.data.model.ProjectEntity
import io.caster.tutorial.domain.model.Project

object ProjectFactory {

    fun makeProjectEntity(): ProjectEntity {
        return ProjectEntity(DataFactory.randomString(),
            DataFactory.randomString(),DataFactory.randomString(),
            DataFactory.randomString(),DataFactory.randomString(),
            DataFactory.randomString(),DataFactory.randomString(),
            DataFactory.randomBoolean())
    }

    fun makeProject(): Project {
        return Project(DataFactory.randomString(),
            DataFactory.randomString(),DataFactory.randomString(),
            DataFactory.randomString(),DataFactory.randomString(),
            DataFactory.randomString(),DataFactory.randomString(),
            DataFactory.randomBoolean())
    }

}

