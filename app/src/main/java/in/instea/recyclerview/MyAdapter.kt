package `in`.instea.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val newsArray: ArrayList<NewsContent>, val contex: Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsS: TextView = itemView.findViewById<TextView>(R.id.newsTV)
        val newsI: ImageView = itemView.findViewById<ImageView>(R.id.newsIV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = newsArray[position]
        holder.newsS.text = currentItem.news
        holder.newsI.setImageResource(currentItem.imageId)
    }

    override fun getItemCount(): Int {
        return newsArray.size
    }

}