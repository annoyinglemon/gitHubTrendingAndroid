package io.caster.tutorial.mobile_ui.injection.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.caster.tutorial.data.repository.ProjectsRemote
import io.caster.tutorial.mobile_ui.BuildConfig
import io.caster.tutorial.remote.ProjectsRemoteImpl
import io.caster.tutorial.remote.service.GitHubTrendingService
import io.caster.tutorial.remote.service.GitHubTrendingServiceFactory

@Module
abstract class RemoteModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideGithubService(): GitHubTrendingService {
            return GitHubTrendingServiceFactory.makeGitHubTrendingService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindProjectsRemote(projectsRemote: ProjectsRemoteImpl): ProjectsRemote

}