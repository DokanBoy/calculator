package pw.zakharov.calculator.service

import org.springframework.stereotype.Service
import pw.zakharov.calculator.model.User
import pw.zakharov.calculator.repository.UserRepository

@Service
class UserService(private val userRepository: UserRepository) {

    fun getOrCreate(username: String): User {
        val user: User? = userRepository.findFirstByUsername(username);
        if (user != null) return user;

        return userRepository.save(User(null, username))
    }

}