package persistence

interface Repository<T> {
    fun create(item: T)
    fun update(item: T)
    fun getAll(): List<T>
    fun getById(id: Long): T
    fun delete(item: T)
}