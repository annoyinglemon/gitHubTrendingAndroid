package com.example.tutorials.mapper

import com.example.tutorials.model.ProjectView
import io.caster.tutorial.domain.model.Project
import javax.inject.Inject

class ProjectViewMapper @Inject constructor(): Mapper<ProjectView, Project>{

    override fun mapToView(type: Project): ProjectView {
        return ProjectView(type.id, type.name, type.fullName, type.starCount, type.dateCreated,
            type.ownerName, type.ownerAvatar, type.isBookmarked)
    }

}