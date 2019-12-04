package app.foca.sweetbitterbeer.data

import androidx.room.TypeConverter
import app.foca.sweetbitterbeer.model.Hop
import app.foca.sweetbitterbeer.model.Malt
import app.foca.sweetbitterbeer.model.MashTemp
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken


class TypeConverter {
    @TypeConverter
    fun listToJson(value: List<String>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<String>? {

        val objects =
            Gson().fromJson(value, Array<String>::class.java) as Array<String>
        val list = objects.toList()
        return list
    }

    @TypeConverter
    fun listHopToJson(value: List<Hop>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonHopToList(value: String): List<Hop>? {

        val objects =
            Gson().fromJson(value, Array<Hop>::class.java) as Array<Hop>
        val list = objects.toList()
        return list
    }

    @TypeConverter
    fun listMaltToJson(value: List<Malt>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonMaltToList(value: String): List<Malt>? {

        val objects =
            Gson().fromJson(value, Array<Malt>::class.java) as Array<Malt>
        val list = objects.toList()
        return list
    }

    @TypeConverter
    fun listMashTempToJson(value: List<MashTemp>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonMashTempToList(value: String): List<MashTemp>? {

        val objects =
            Gson().fromJson(value, Array<MashTemp>::class.java) as Array<MashTemp>
        val list = objects.toList()
        return list
    }
}