package ru.mikolaych.recyclerviewbyneco

import android.util.Property
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mikolaych.recyclerviewbyneco.databinding.HomeItemBinding

class HomeAdaptor: RecyclerView.Adapter<HomeAdaptor.HomeHolder>() {

    private val homelist = ArrayList<Home>()


    class HomeHolder(item:View):RecyclerView.ViewHolder(item) {
        private val binding = HomeItemBinding.bind(item)

        fun bind(home: Home) = with(binding) {
            im.setImageResource(home.imageId)
            tvTittle.text = home.title

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
        return HomeHolder(view)

    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
       holder.bind(homelist[position])

    }

    override fun getItemCount(): Int {
        return homelist.size
    }

    fun addHome(home: Home){
        homelist.add(home)
        notifyDataSetChanged()

    }
    fun removeItem(position: Int){
        homelist.removeAt(position)
        notifyItemRemoved(position)



    }
}
