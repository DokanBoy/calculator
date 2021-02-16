package pw.zakharov.calculator.repository

import org.springframework.data.repository.CrudRepository
import pw.zakharov.calculator.model.User

interface UserRepository : CrudRepository<User, Long> {

    fun findFirstByUsername(username: String) : User?

}