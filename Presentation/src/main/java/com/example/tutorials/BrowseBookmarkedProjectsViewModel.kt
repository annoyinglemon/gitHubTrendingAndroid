package com.example.tutorials

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.tutorials.mapper.ProjectViewMapper
import com.example.tutorials.model.ProjectView
import com.example.tutorials.state.Resource
import com.example.tutorials.state.ResourceState
import io.caster.tutorial.domain.interactor.bookmark.GetBookmarkedProjects
import io.caster.tutorial.domain.model.Project
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class BrowseBookmarkedProjectsViewModel @Inject constructor(
    private val getBookmarkedProjects: GetBookmarkedProjects,
    private val mapper: ProjectViewMapper): ViewModel() {

    private val liveData = MutableLiveData<Resource<List<ProjectView>>>()

    override fun onCleared() {
        getBookmarkedProjects.dispose()
        super.onCleared()
    }

    fun getProjects(): LiveData<Resource<List<ProjectView>>> {
        return liveData
    }

    fun fetchProjects() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        //        TODO("test this without 'return' ")
        getBookmarkedProjects.execute(ProjectsSubscriber())
    }

    inner class ProjectsSubscriber: DisposableObserver<List<Project>>() {
        override fun onComplete() {}

        override fun onNext(t: List<Project>) {
            liveData.postValue(Resource(ResourceState.SUCCESS,
                t.map {
                    mapper.mapToView(it)
                }, null))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }
    }
}