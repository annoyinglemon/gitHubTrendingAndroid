package io.caster.tutorial.mobile_ui.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import io.caster.tutorial.mobile_ui.GithubTrendingApplication

import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: GithubTrendingApplication)

}