package clpal.viewmodelfactory.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import clpal.viewmodelfactory.Model.User
import clpal.viewmodelfactory.Repository.UserRepository

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    val userMutableLiveData: MutableLiveData<List<User>> = MutableLiveData()
    fun getData() {
        val response = userRepository.getUserData()
        userMutableLiveData.value = response
    }
}