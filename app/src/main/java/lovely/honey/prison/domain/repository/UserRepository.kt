package lovely.honey.prison.domain.repository

interface UserRepository {
    fun setFirstEnter(isFirstEnter: Boolean)
    fun getFirstEnter(): Boolean
}