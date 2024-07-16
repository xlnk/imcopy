package io.github.xlnk.telegramcopy.data.local.database

import android.content.Context
import androidx.room.Room

internal class AppDatabaseFactory {

    fun create(context: Context): AppDatabase = Room
        .databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = "app-database"
        )
        .build()
}