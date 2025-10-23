package lovely.honey.prison.data.repository

import android.content.Context
import android.content.SharedPreferences
import lovely.honey.prison.domain.repository.UserRepository

class UserRepositoryImpl (
    private var context: Context
) : UserRepository {

    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    }

    companion object {
        private const val KEY_FIRST_ENTER = "key_first_enter"
    }

    override fun setFirstEnter(isFirstEnter: Boolean) {
        prefs.edit()
            .putBoolean(KEY_FIRST_ENTER, isFirstEnter)
            .apply()
    }

    override fun getFirstEnter(): Boolean {
        val enterValue = prefs.getBoolean(KEY_FIRST_ENTER, true)
        return enterValue
    }
}