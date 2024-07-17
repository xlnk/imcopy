package io.github.xlnk.telegramcopy.data.local.mapper

import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import javax.inject.Inject

class EntityIdDataMapper @Inject constructor() {

    fun toDomain(id: String) = EntityId(id)

    fun toData(id: EntityId) = id.value
}