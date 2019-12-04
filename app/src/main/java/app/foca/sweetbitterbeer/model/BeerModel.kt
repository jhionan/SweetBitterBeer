package app.foca.sweetbitterbeer.model

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "beers")
data class Beer(
    @SerializedName("abv")
    val abv: Double? = 0.0,
    @SerializedName("attenuation_level")
    val attenuationLevel: Int?,
    @SerializedName("boil_volume")
    @Embedded(prefix = "beer_")
    val boilVolume: BoilVolume?,
    @ColumnInfo(name = "brewers_tips")
    @SerializedName("brewers_tips")
    val brewersTips: String?,
    @ColumnInfo(name = "contributed_by")
    @SerializedName("contributed_by")
    val contributedBy: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("ebc")
    val ebc: Int?,
    @ColumnInfo(name = "first_brewed")
    @SerializedName("first_brewed")
    val firstBrewed: String?,
    @ColumnInfo(name = "food_pairing")
    @SerializedName("food_pairing")
    val foodPairing: List<String?>?,
    @SerializedName("ibu")
    val ibu: Int?,
    @PrimaryKey
    @SerializedName("id")
    val id: Int?,
    @ColumnInfo(name = "image_url")
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("ingredients")
    @Embedded(prefix = "beer_")
    val ingredients: Ingredients?,
    @SerializedName("method")
    @Embedded(prefix = "beer_")
    val method: Method?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("ph")
    val ph: Double?,
    @SerializedName("srm")
    val srm: Int?,
    @SerializedName("tagline")
    val tagline: String?,
    @ColumnInfo(name = "target_fg")
    @SerializedName("target_fg")
    val targetFg: Int?,
    @ColumnInfo(name = "target_og")
    @SerializedName("target_og")
    val targetOg: Int?,
    @SerializedName("volume")
    @Embedded(prefix = "beer_")
    val volume: Volume?
)
@Entity(tableName = "boil_volume")
data class BoilVolume(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("unit")
    val unit: String?,
    @SerializedName("value")
    val value: Int?
)

@Entity(tableName = "ingredients")
data class Ingredients(
    @SerializedName("hops")
    var hops: List<Hop?>?,
    @SerializedName("malt")
    var malt: List<Malt?>?,
    @SerializedName("yeast")
    var yeast: String?
)
@Entity(tableName = "hop")
data class Hop(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("add")
    val add: String?,
    @SerializedName("amount")
    @Embedded(prefix = "hop_")
    val amount: Amount?,
    @SerializedName("attribute")
    val attribute: String?,
    @SerializedName("name")
    val name: String?
)
@Entity(tableName = "amount")
data class Amount(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("unit")
    val unit: String?,
    @SerializedName("value")
    val value: Int?
)
@Entity(tableName = "malt")
data class Malt(
    @SerializedName("amount")
    @Embedded(prefix = "malt_")
    val amount: Amount?,
    @SerializedName("name")
    val name: String?
)
@Entity(tableName = "method")
data class Method(
    @SerializedName("fermentation")
    @Embedded(prefix = "method_")
    val fermentation: Fermentation?,
    @SerializedName("mash_temp")
    var mashTemp: List<MashTemp?>?
)
@Entity(tableName = "fermentation")
data class Fermentation(
    @SerializedName("temp")
    @Embedded(prefix = "fermentation_")
    val temp: Temp?
)
@Entity(tableName = "temp")
data class Temp(
    @SerializedName("unit")
    val unit: String?,
    @SerializedName("value")
    val value: Int?
)
@Entity(tableName = "mash_temp")
data class MashTemp(
    @SerializedName("duration")
    val duration: Int?,
    @SerializedName("temp")
    @Embedded
    val temp: Temp?
)
@Entity(tableName = "volume")
data class Volume(
    @ColumnInfo(name = "volume_unit")
    @SerializedName("unit")
    val unit: String? = "",
    @ColumnInfo(name = "volume_value")
    @SerializedName("value")
    val value: Int? = 0
)
