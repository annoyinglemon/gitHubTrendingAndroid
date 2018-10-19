package io.caster.tutorial.remote.mapper

import io.caster.tutorial.remote.test.factory.ProjectDataFactory
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals


@RunWith(JUnit4::class)
class ProjectResponseModelMapperTest {

    private val mapper = ProjectResponseModelMapper()

    @Test
    fun mapFromModelMapsData() {
        val model = ProjectDataFactory.makeProject()
        val entity = mapper.mapFromModel(model)
        assertEquals(model.id, entity.id)
        assertEquals(model.name, entity.name)
        assertEquals(model.fullname, entity.fullName)
        assertEquals(model.starCount.toString(), entity.starCount)
        assertEquals(model.dateCreated, entity.dateCreated)
        assertEquals(model.owner.ownerName, entity.ownerName)
        assertEquals(model.owner.ownerAvatar, entity.ownerAvatar)
    }

}