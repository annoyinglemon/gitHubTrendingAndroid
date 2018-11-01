package io.caster.tutorial.mobile_ui.injection.module

import dagger.Binds
import dagger.Module
import io.caster.tutorial.data.ProjectsDataRepository
import io.caster.tutorial.domain.repository.ProjectsRepository

@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: ProjectsDataRepository): ProjectsRepository



}