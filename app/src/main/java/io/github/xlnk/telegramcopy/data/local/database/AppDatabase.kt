package io.github.xlnk.telegramcopy.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.xlnk.telegramcopy.data.local.dao.ChatDenormalizedDao
import io.github.xlnk.telegramcopy.data.local.model.ChatDenormalizedEntity

@Database(
    entities = [ChatDenormalizedEntity::class],
    version = 1,
    exportSchema = true,
    autoMigrations = [],
)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun chatDenormalizedDao(): ChatDenormalizedDao
}