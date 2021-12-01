package clpal.viewmodelfactory.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import clpal.viewmodelfactory.Model.User
import clpal.viewmodelfactory.R

// https://www.tutorialspoint.com/working-with-recyclerview-in-an-android-app-using-kotlin
// https://www.geeksforgeeks.org/android-recyclerview-in-kotlin/
class UserAdapter( private var userlist: List<User>) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val countrytextView: TextView = view.findViewById(R.id.countrytextView)
        val capitaltextView: TextView = view.findViewById(R.id.capitaltextView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val itemViewModel=userlist.get(position)

        holder.countrytextView.text=itemViewModel.country
        holder.capitaltextView.text=itemViewModel.capital

    }

    override fun getItemCount(): Int {
        return userlist.size

    }
fun setUserData(_userlist: ArrayList<User>){
    this.userlist=_userlist
}
}