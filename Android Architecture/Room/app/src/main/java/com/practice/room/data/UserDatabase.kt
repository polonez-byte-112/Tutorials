package com.practice.room.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.practice.room.model.User


//Ctrl Q pokazuje  co dany kod robi
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){

    abstract  fun userDao() : UserDao


    //Kod nizej mówi że bedzie tylko jedna instancja tablicy (nie bedzie duplikatów w bazie )
    companion object{
        //Volatile sprawia ze z automatu jest widoczny do wszystkich wątków
        @Volatile
        private var INSTANCE : UserDatabase? = null


        fun getDatabase(context : Context): UserDatabase{
            //Sprawdzamy czy instance którą robimy jest null jesli tak to tworzymy instance w synchronized a jesli nie to zwracamy
            // i nie było tematu
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }

            //synchronized block chroni kod od rownolegle exekucje przez wątki
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "user_database").build()
                INSTANCE = instance
                return  instance
            }
        }
    }
}