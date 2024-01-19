package `in`.instea.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*since data may present in arraylist but recyclerView only takes data is a particular format,
so RecyclerView Adapter helps data to adapt in recyclerView */

class MyAdapter(private val newsArray: ArrayList<NewsContent>, val contex: Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        //utne hi views generate honge rows ke jitne ek bar me screen pe dikh sakte hain, to un views viewholder store (hold) krta h
    class MyViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsS: TextView = itemView.findViewById<TextView>(R.id.newsTV)
        val newsI: ImageView = itemView.findViewById<ImageView>(R.id.newsIV)
    }

    //oncrreate view holder generate only number of views which is sufficient for its screen
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        
        /* layout inflator returns views object corresponding all the views defined in the layout
        i.e inflator converts the xml files into correspondign java object */
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_row, parent, false)
        //views created by the inflator will passed to the viewholder to keep it or hold it
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
