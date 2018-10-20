package io.caster.tutorial.cache.mapper

import io.caster.tutorial.cache.model.CachedProject
import io.caster.tutorial.data.model.ProjectEntity

class CachedProjectMapper : CacheMapper<CachedProject, ProjectEntity> {

    override fun mapFromCached(cachedProject: CachedProject): ProjectEntity {
        return ProjectEntity(cachedProject.id, cachedProject.name, cachedProject.fullName,
            cachedProject.starCount, cachedProject.dateCreated, cachedProject.ownerName, cachedProject.ownerAvatar,
            cachedProject.isBookmarked)
    }

    override fun mapToCached(projectEntity: ProjectEntity): CachedProject {
        return CachedProject(projectEntity.id, projectEntity.name, projectEntity.fullName,
            projectEntity.starCount, projectEntity.dateCreated, projectEntity.ownerName,
            projectEntity.ownerAvatar, projectEntity.isBookmarked)
    }

}