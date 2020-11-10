package luiz.souza.exrecyclerviewcardview.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import luiz.souza.exrecyclerviewcardview.model.Client

@Database(entities = arrayOf(Client::class), version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun clientDAO(): ClientDAO

    companion object {
        var INSTANCE: AppDatabase? = null

        fun openDatabase(context: Context): AppDatabase? {
            if(INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "client.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        fun closeDatabase() {
            INSTANCE = null
        }
    }

}