package com.siarheikrupenich.domain

import com.siarheikrupenich.domain.mapper.RepoEntityMapper
import com.siarheikrupenich.domain.mapper.RepoEntityMapperImpl
import com.siarheikrupenich.testrepo.entity.RepoApiEntity
import org.junit.Assert.assertEquals
import org.junit.Test

class RepoEntityMapperTest {

    private val mapper: RepoEntityMapper = RepoEntityMapperImpl()

    @Test
    fun `convert() return expected value`() {
        val repoApiEntities = listOf(
            RepoApiEntity(1, "repo 1", "desc 1"),
            RepoApiEntity(2, "repo 2", "desc 2"),
            RepoApiEntity(3, "repo 3", "desc 3")
        )

        repoApiEntities.forEach { repoApiEntity ->
            val test = mapper.map(repoApiEntity)
            assertEquals(repoApiEntity.id, test.id)
        }
    }
}