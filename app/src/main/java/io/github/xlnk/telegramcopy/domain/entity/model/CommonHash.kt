package io.github.xlnk.telegramcopy.domain.entity.model

data class CommonHash(val bytes: ByteArray) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CommonHash

        return bytes.contentEquals(other.bytes)
    }

    override fun hashCode(): Int {
        return bytes.contentHashCode()
    }

    companion object {

        fun empty(): CommonHash = CommonHash(ByteArray(0))
    }
}