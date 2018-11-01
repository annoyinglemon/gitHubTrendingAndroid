package io.caster.tutorial.mobile_ui.injection.module

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.caster.tutorial.domain.executor.PostExecutionThread
import io.caster.tutorial.mobile_ui.UiThread
import io.caster.tutorial.mobile_ui.browse.BrowseActivity

@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesBrowseActivity(): BrowseActivity

}