package io.github.xlnk.telegramcopy.data.local.mapper

import io.github.xlnk.telegramcopy.domain.entity.model.EntityId

class EntityIdMapper {

    fun toDomain(id: String) = EntityId(id)
}