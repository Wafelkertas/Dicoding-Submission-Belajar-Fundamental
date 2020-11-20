package com.shidqi.githubprofiles.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shidqi.githubprofiles.models.Item


@Database(
    entities = [Item::class],
    version = 1,
    exportSchema = false
)
abstract class ItemDatabase : RoomDatabase() {

    // Fungsi Abstract untuk memanggil DAO
    abstract fun getItemDao(): ItemDao

    companion object{
        @Volatile
        private var instance: ItemDatabase? = null
        private val LOCK = Any()


        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also{ instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ItemDatabase::class.java,
                "item_db.db"
            ).build()
    }
}