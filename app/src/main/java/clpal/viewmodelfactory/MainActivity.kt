package clpal.viewmodelfactory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import clpal.viewmodelfactory.Adapter.UserAdapter
import clpal.viewmodelfactory.Model.User
import clpal.viewmodelfactory.Repository.UserRepository
import clpal.viewmodelfactory.ViewModel.UserViewModel
import clpal.viewmodelfactory.ViewModel.UserViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var userViewModel: UserViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //https://www.youtube.com/watch?v=Cs4VuyZYhC8
        val userRepository = UserRepository()
        val userViewModelFactory = UserViewModelFactory(userRepository)
        userViewModel = ViewModelProvider(this, userViewModelFactory)[UserViewModel::class.java]
        userViewModel.getData()
        userViewModel.userMutableLiveData.observe(this, Observer {
            userAdapter.setUserData(it as ArrayList<User>)
        })
        initRecyleView()
    }

    private fun initRecyleView() {
        recyclerView = findViewById(R.id.recyclerView)
        userAdapter = UserAdapter(ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }
}