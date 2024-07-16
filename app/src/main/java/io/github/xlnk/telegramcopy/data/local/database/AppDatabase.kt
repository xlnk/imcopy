package io.github.xlnk.telegramcopy.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.github.xlnk.telegramcopy.data.local.dao.ChatDenormalizedDao
import io.github.xlnk.telegramcopy.data.local.model.ChatDenormalizedEntity
import io.github.xlnk.telegramcopy.data.local.typeconverter.LocalDateTimeTypeConverter

@Database(
    entities = [ChatDenormalizedEntity::class],
    version = 1,
    exportSchema = true,
    autoMigrations = [],
)
@TypeConverters(LocalDateTimeTypeConverter::class)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun chatDenormalizedDao(): ChatDenormalizedDao
}