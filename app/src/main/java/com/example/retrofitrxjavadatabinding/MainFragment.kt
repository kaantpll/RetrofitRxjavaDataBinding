package com.example.retrofitrxjavadatabinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitrxjavadatabinding.adapter.FoodAdapter
import com.example.retrofitrxjavadatabinding.model.Food
import com.example.retrofitrxjavadatabinding.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    private lateinit var viewModel : MainViewModel
    private var adapter = FoodAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.fecthData()

        myRecyclerview.layoutManager = LinearLayoutManager(context)
        myRecyclerview.adapter = adapter



       observeData()
    }

    private fun observeData() {
        viewModel.foodList.observe(viewLifecycleOwner, Observer {
            list-> list?.let {

                myRecyclerview.visibility = View.VISIBLE
                adapter.updateList(list as ArrayList<Food>)

        }
        })
    }
}