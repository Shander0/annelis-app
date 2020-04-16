package shander.annelisapp.room.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import io.reactivex.CompletableObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import shander.annelisapp.App
import shander.annelisapp.room.dao.*
import shander.annelisapp.room.entity.Material
import shander.annelisapp.room.entity.Photo
import shander.annelisapp.room.entity.Project
import shander.annelisapp.room.entity.ProjectWithAllNested
import shander.annelisapp.room.entity.defaultMeasures.DefaultListMeasures
import shander.annelisapp.room.entity.defaultMeasures.DefaultMeasurement
import shander.annelisapp.room.entity.measurements.ListMeasures
import shander.annelisapp.room.entity.measurements.Measurement
import shander.annelisapp.room.entity.tasks.TaskFirstLevel
import shander.annelisapp.room.entity.tasks.TaskSecondLevel
import shander.annelisapp.room.entity.tasks.TaskThirdLevel

@Database(entities = [Project::class, Photo::class, Material::class, ListMeasures::class,
Measurement::class, TaskFirstLevel::class, TaskSecondLevel::class, TaskThirdLevel::class,
DefaultListMeasures::class, DefaultMeasurement::class], version = 2, exportSchema = true)
public abstract class ProjectsDatabase : RoomDatabase() {

    abstract fun projectsDao(): ProjectsDao
    abstract fun measurementDao(): MeasurementDao
    abstract fun photoDao(): PhotoDao
    abstract fun listMeasuresDao(): ListMeasuresDao
    abstract fun materialDao(): MaterialDao
    abstract fun taskFirstDao(): TaskFirstLevelDao
    abstract fun taskSecondDao(): TaskSecondLevelDao
    abstract fun taskThirdDao(): TaskThirdLevelDao
    abstract fun defaultMeasureDao(): DefaultMeasureDao
    abstract fun defaultMeasuresListDao(): DefaultMeasuresListDao

    private class ProjectsDatabaseCallback: RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE!!.projectsDao().insert(
                Project(1, "test1", "", "", 0)
            ).concatWith(INSTANCE!!.listMeasuresDao().insert(
                ListMeasures(1, "list1", "",  1)))
                .concatWith( INSTANCE!!.measurementDao().insert(
                    Measurement(1, 1, "m1", "", "", 2.0, "")))
                .concatWith(INSTANCE!!.materialDao().insert(
                    Material(1, "mat1", 0.1, 0.2, 0, "", 1)))
                .concatWith(INSTANCE!!.photoDao().insert(
                    Photo(1, 1, "")))
                .concatWith(INSTANCE!!.taskFirstDao().insert(
                    TaskFirstLevel(1, 1,"", 0, 0, 0)))
                .concatWith(INSTANCE!!.taskSecondDao().insert(
                    TaskSecondLevel(1, 1, "", 0, 0, 0)))
                .concatWith(INSTANCE!!.taskThirdDao().insert(
                    TaskThirdLevel(1,1,"", 0,0,0)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(object : CompletableObserver {
                    override fun onComplete() {
                        Log.wtf("Prefill", "completed")
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        Log.wtf("Prefill", "Error: " + e.localizedMessage)
                    }
                })


            INSTANCE!!.projectsDao().insert(
                Project(2, "test2222", "", "", 0)
            ).concatWith(INSTANCE!!.listMeasuresDao().insert(
                ListMeasures(2, "list1", "",  2)))
                .concatWith( INSTANCE!!.measurementDao().insert(
                    Measurement(2, 2, "m2", "", "", 2.0, "")))
                .concatWith(INSTANCE!!.materialDao().insert(
                    Material(2, "mat2", 0.1, 0.2, 0, "", 2)))
                .concatWith(INSTANCE!!.photoDao().insert(
                    Photo(2, 2, "")))
                .concatWith(INSTANCE!!.taskFirstDao().insert(
                    TaskFirstLevel(2, 2,"", 0, 0, 0)))
                .concatWith(INSTANCE!!.taskSecondDao().insert(
                    TaskSecondLevel(2, 2, "", 0, 0, 0)))
                .concatWith(INSTANCE!!.taskThirdDao().insert(
                    TaskThirdLevel(2,2,"", 0,0,0)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(object : CompletableObserver {
                    override fun onComplete() {
                        Log.wtf("Prefill", "completed")
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        Log.wtf("Prefill", "Error: " + e.localizedMessage)
                    }
                })
            INSTANCE!!.projectsDao().insert(
                Project(3, "test333333", "", "", 0)
            ).concatWith(INSTANCE!!.listMeasuresDao().insert(
                ListMeasures(3, "list3", "",  3)))
                .concatWith( INSTANCE!!.measurementDao().insert(
                    Measurement(3, 3, "m1", "", "", 2.0, "")))
                .concatWith(INSTANCE!!.materialDao().insert(
                    Material(3, "mat1", 0.1, 0.2, 0, "", 3)))
                .concatWith(INSTANCE!!.photoDao().insert(
                    Photo(3, 3, "")))
                .concatWith(INSTANCE!!.taskFirstDao().insert(
                    TaskFirstLevel(3, 3,"", 0, 0, 0)))
                .concatWith(INSTANCE!!.taskSecondDao().insert(
                    TaskSecondLevel(3, 3, "", 0, 0, 0)))
                .concatWith(INSTANCE!!.taskThirdDao().insert(
                    TaskThirdLevel(3,3,"", 0,0,0)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(object : CompletableObserver {
                    override fun onComplete() {
                        Log.wtf("Prefill", "completed")
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        Log.wtf("Prefill", "Error: " + e.localizedMessage)
                    }
                })
            INSTANCE!!.projectsDao().insert(
                Project(4, "test44444", "", "", 0)
            ).concatWith(INSTANCE!!.listMeasuresDao().insert(
                ListMeasures(4, "list4", "",  4)))
                .concatWith( INSTANCE!!.measurementDao().insert(
                    Measurement(4, 4, "m1", "", "", 2.0, "")))
                .concatWith(INSTANCE!!.materialDao().insert(
                    Material(4, "mat4", 0.1, 0.2, 0, "", 4)))
                .concatWith(INSTANCE!!.photoDao().insert(
                    Photo(4, 4, "")))
                .concatWith(INSTANCE!!.taskFirstDao().insert(
                    TaskFirstLevel(4, 4,"", 0, 0, 0)))
                .concatWith(INSTANCE!!.taskSecondDao().insert(
                    TaskSecondLevel(4, 4, "", 0, 0, 0)))
                .concatWith(INSTANCE!!.taskThirdDao().insert(
                    TaskThirdLevel(4,4,"", 0,0,0)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(object : CompletableObserver {
                    override fun onComplete() {
                        Log.wtf("Prefill", "completed")
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        Log.wtf("Prefill", "Error: " + e.localizedMessage)
                    }
                })
            INSTANCE!!.projectsDao().insert(
                Project(5, "test55", "", "", 0)
            ).concatWith(INSTANCE!!.listMeasuresDao().insert(
                ListMeasures(5, "list5", "",  5)))
                .concatWith( INSTANCE!!.measurementDao().insert(
                    Measurement(5, 5, "m1", "", "", 2.0, "")))
                .concatWith(INSTANCE!!.materialDao().insert(
                    Material(5, "mat1", 0.1, 0.2, 0, "", 5)))
                .concatWith(INSTANCE!!.photoDao().insert(
                    Photo(5, 5, "")))
                .concatWith(INSTANCE!!.taskFirstDao().insert(
                    TaskFirstLevel(5, 5,"", 0, 0, 0)))
                .concatWith(INSTANCE!!.taskSecondDao().insert(
                    TaskSecondLevel(5, 5, "", 0, 0, 0)))
                .concatWith(INSTANCE!!.taskThirdDao().insert(
                    TaskThirdLevel(5,5,"", 0,0,0)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(object : CompletableObserver {
                    override fun onComplete() {
                        Log.wtf("Prefill", "completed")
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        Log.wtf("Prefill", "Error: " + e.localizedMessage)
                    }
                })

        }
    }

    companion object {

        @Volatile
        private var INSTANCE: ProjectsDatabase? = null

        fun getDatabase(): ProjectsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    App.instance,
                    ProjectsDatabase::class.java,
                    "projects_database"
                ).addCallback(ProjectsDatabaseCallback()).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}