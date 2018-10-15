package io.caster.tutorial.data.repository

import io.caster.tutorial.data.model.ProjectEntity
import io.reactivex.Observable

interface ProjectsRemote {

    fun getProjects(): Observable<List<ProjectEntity>>

}