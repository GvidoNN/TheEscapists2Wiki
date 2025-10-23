package lovely.honey.prison.data.repository

import android.content.Context
import lovely.honey.prison.data.db.AppDatabase
import lovely.honey.prison.data.db.toItems
import lovely.honey.prison.domain.models.Items
import lovely.honey.prison.domain.models.toItemDbEntity

class FavouriteItemsRepositoryImpl(context: Context) {

    private val itemsDao = AppDatabase.getInstance(context).itemsDao()

    fun getAllItems(): List<Items> {
        try {
            return itemsDao.getAll().toItems()
        } catch (e: Exception) {
            return emptyList()
        }
    }

    fun insertItems(item: Items) {
        try {
            itemsDao.insertAll(item.toItemDbEntity())
        } catch (e: Exception) { }
    }

    fun deleteItem(item: Items) {
        try {
            itemsDao.delete(item.toItemDbEntity())
        } catch (e: Exception) { }
    }
}