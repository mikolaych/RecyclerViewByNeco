package ru.mikolaych.recyclerviewbyneco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.mikolaych.recyclerviewbyneco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding? = null
    private val adapter = HomeAdaptor()
    private val itemIdArray = listOf(
        R.drawable.flat0,
        R.drawable.flat1,
        R.drawable.flat2,
        R.drawable.flat3,
        R.drawable.flat4,
        R.drawable.flat5,
        R.drawable.flat6,
        R.drawable.flat7,
        R.drawable.flat8,
        R.drawable.flat9,
    )
    private var index = 0
    private var number:Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        init()
    }

    private fun init() {
        binding?.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            rcView.adapter = adapter
            add.setOnClickListener {
                if (index > 9) index = 0
                val  home = Home(itemIdArray[index], title = "Квартира $number ")
                adapter.addHome(home)
                index++
                number ++
            }

        }
    }
    private fun removeItem(view:View){
        binding?.apply {
            val index = index
            remove.setOnClickListener{
                adapter.notifyItemRemoved(index)
            }
        }
    }


}