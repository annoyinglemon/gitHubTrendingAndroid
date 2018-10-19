package io.caster.tutorial.remote.test.factory

import io.caster.tutorial.data.model.ProjectEntity
import io.caster.tutorial.remote.model.OwnerModel
import io.caster.tutorial.remote.model.ProjectModel
import io.caster.tutorial.remote.model.ProjectsResponseModel

object ProjectDataFactory {

    fun makeOwner(): OwnerModel {
        return OwnerModel(DataFactory.randomString(), DataFactory.randomString())
    }

    fun makeProject(): ProjectModel {
        return ProjectModel(DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomInt(),
            DataFactory.randomString(), makeOwner())
    }

    fun makeProjectEntity(): ProjectEntity {
        val ownerModel = makeOwner()
        return ProjectEntity(DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), DataFactory.randomString(),
            DataFactory.randomString(), ownerModel.ownerName, ownerModel.ownerAvatar)
    }

    fun makeProjectResponse(): ProjectsResponseModel {
        return ProjectsResponseModel(listOf(makeProject(), makeProject(), makeProject(), makeProject(), makeProject()))
    }

}