package io.caster.tutorial.remote.mapper

import io.caster.tutorial.data.model.ProjectEntity
import io.caster.tutorial.remote.model.ProjectModel

class ProjectResponseModelMapper : ModelMapper<ProjectModel, ProjectEntity> {

    override fun mapFromModel(model: ProjectModel): ProjectEntity {
        return ProjectEntity(model.id, model.name, model.fullname, model.starCount.toString(),
            model.dateCreated, model.owner.ownerName, model.owner.ownerAvatar)
    }

}