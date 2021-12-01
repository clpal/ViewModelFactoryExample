package clpal.viewmodelfactory.Repository

import clpal.viewmodelfactory.Model.User

class UserRepository {
    fun getUserData():List<User>{
       val userList= ArrayList<User>()
        userList.add(User("India"," Delhi"))
        userList.add(User("Nepal","Kathmandu"))
        userList.add(User("England","London"))
        userList.add(User("Nepal","Bhutan"))
        userList.add(User("SriLanka","Colombo"))
        userList.add(User("Pakistan","Islamabad"))

        userList.add(User("Afganistan","Kabul"))
        userList.add(User("Banladesh","Dhaka"))
        userList.add(User("unknown","Vienna"))
        userList.add(User("rangyn","Manama"))
        userList.add(User("unknown","Baku"))
        return userList
    }
}