package io.caster.tutorial.cache.dao

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import io.caster.tutorial.cache.db.ProjectsDatabase
import io.caster.tutorial.cache.test.factory.ConfigDataFactory
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import kotlin.test.assertEquals


@RunWith(RobolectricTestRunner::class)
class ConfigDaoTest {

    @Rule
    @JvmField var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val database = Room.inMemoryDatabaseBuilder(
        RuntimeEnvironment.application.applicationContext,
        ProjectsDatabase::class.java)
        .allowMainThreadQueries()
        .build()

    @After
    fun clearDb() {
        database.close()
    }

    @Test
    fun saveConfigurationSavesData() {
        val config = ConfigDataFactory.makeCachedConfig()
        database.configDao().insertConfig(config)

        val config1 = database.configDao().getConfig().test().values()[0]
        assertEquals(config.lastCacheTime, config1.lastCacheTime)
    }

}