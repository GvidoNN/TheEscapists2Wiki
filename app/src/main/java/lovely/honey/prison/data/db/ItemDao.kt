package lovely.honey.prison.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Query("SELECT * FROM main_items")
    fun getAll(): List<ItemDbEntity>

    @Insert
    fun insertAll(item: ItemDbEntity)

    @Delete
    fun delete(item: ItemDbEntity)
}