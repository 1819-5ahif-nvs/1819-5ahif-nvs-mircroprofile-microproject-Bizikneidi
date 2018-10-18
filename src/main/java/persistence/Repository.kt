package persistence

interface Repository<T> {
    fun create(item: T): T
    fun update(item: T)
    fun getAll(): List<T>
    fun getById(id: Long): T
    fun delete(id: Long)
}