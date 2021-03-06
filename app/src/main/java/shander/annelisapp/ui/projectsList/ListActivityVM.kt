package shander.annelisapp.ui.projectsList

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import shander.annelisapp.App
import shander.annelisapp.innerEntity.SimpleProjectItem
import shander.annelisapp.room.db.ProjectsDatabase
import shander.annelisapp.room.entity.Project
import shander.annelisapp.room.entity.ProjectWithAllNested
import shander.annelisapp.ui.projectSummary.ProjectSummaryActivity
import shander.annelisapp.utils.ProjectWANToSimpleConverter

class ListActivityVM: ViewModel(), ProjectsAdapter.ProjectClickListener {
    private var subscription: CompositeDisposable
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val projectsAdapter = ProjectsAdapter(this)
    val db: ProjectsDatabase = ProjectsDatabase.getDatabase()

    init {
        onLoadProjectsListStart()
        subscription = CompositeDisposable()
        subscription.add(db.projectsDao().getAll()
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onLoadProjectsListSuccess(it) }))
    }

    fun projectDelete(position: Int) {
        if (position!=-1) {
        subscription.add(db.projectsDao().deleteById(projectsAdapter.getIdByPosition(position))
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe())
        }
    }

    private fun onLoadProjectsListStart(){
        loadingVisibility.value = View.VISIBLE
    }

    private fun onLoadProjectsListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onLoadProjectsListSuccess(projectsList:List<ProjectWithAllNested>){
        subscription.add(Observable.just(ProjectWANToSimpleConverter(projectsList).getSimple())
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                {projectsAdapter.updateProjectsList(it)
                onLoadProjectsListFinish()},
                { Log.wtf("FILLING ERROR", it.localizedMessage)}
            ))
    }

    private fun onLoadProjectsListError(){

    }

    override fun onCleared() {
        super.onCleared()
        subscription.clear()
    }

    override fun onProjectClicked(id: Int) {
        val i = Intent(App.instance, ProjectSummaryActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        i.putExtra("id", id)
        App.instance.startActivity(i)
    }
}