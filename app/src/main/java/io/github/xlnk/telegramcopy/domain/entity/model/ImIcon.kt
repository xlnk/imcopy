package io.github.xlnk.telegramcopy.domain.entity.model

data class ImIcon(
    val id: EntityId,
    val width: Int,
    val height: Int,
    val hash: CommonHash,
    val iconBytes: ByteArray
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ImIcon

        if (id != other.id) return false
        if (width != other.width) return false
        if (height != other.height) return false
        if (hash != other.hash) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + width
        result = 31 * result + height
        result = 31 * result + hash.hashCode()
        return result
    }
}
