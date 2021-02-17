package pw.zakharov.calculator.service

import pw.zakharov.calculator.model.User

interface UserService {

    fun getOrCreate(username: String): User

}