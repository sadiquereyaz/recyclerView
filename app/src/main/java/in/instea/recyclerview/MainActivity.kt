package `in`.instea.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL

class MainActivity : AppCompatActivity() {

    private lateinit var myRecyclerView: RecyclerView

    private lateinit var newsContentArray: ArrayList<NewsContent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById<RecyclerView>(R.id.rV)

        val imageIdArray = intArrayOf(
            R.drawable.pic0, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3
        )
        val newsArray = arrayOf(
            "Researchers Develop Breakthrough Treatment for Alzheimer's Disease",
            "Global Tech Giant Unveils Latest Innovation in Renewable Energy",
            "World Health Organization Reports Significant Decline in Malaria Cases",
            "Space Exploration Milestone Achieved as Rover Discovers Signs of Ancient Life on Mars"
        )

//        newsContentArray = arrayListOf<NewsContent>()
        for (index in imageIdArray.indices) {
            val oneNews = NewsContent(imageIdArray[index], newsArray[index])

            newsContentArray.add(oneNews)
        }
        myRecyclerView.layoutManager = LinearLayoutManager(this, VERTICAL, false)
//since data may present in arraylist but recyclerView only takes data is a particular format, so RecyclerView Adapter helps data to adapt in recyclerView
        myRecyclerView.adapter = MyAdapter(newsContentArray, this)      //setting adapter to recyclerView
    }
}
