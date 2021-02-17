package pw.zakharov.calculator.service.impl

import org.springframework.stereotype.Service
import pw.zakharov.calculator.model.User
import pw.zakharov.calculator.repository.UserRepository
import pw.zakharov.calculator.service.UserService

@Service
class SimpleUserService(private val userRepository: UserRepository) : UserService {

    override fun getOrCreate(username: String): User {
        val user: User? = userRepository.findFirstByUsername(username)
        if (user != null) return user

        return userRepository.save(User(null, username))
    }

}