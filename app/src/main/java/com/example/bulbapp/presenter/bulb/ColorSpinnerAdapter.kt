package com.example.bulbapp.presenter.bulb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.bulbapp.databinding.ItemColorBinding

class ColorSpinnerAdapter : BaseAdapter() {

    private val list = mutableListOf<String>()

    fun submitList(list: List<String>) {
        with(this.list) {
            clear()
            addAll(list)
        }
    }

    override fun getCount(): Int =
        list.size

    override fun getItem(p0: Int): String {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long =
        p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup): View {
        val binding = p1?.tag as ItemColorBinding? ?: createBinding(p2.context)

        binding.colorNameTextView.text = list[p0]

        return binding.root
    }

    private fun createBinding(context: Context) : ItemColorBinding {
        val binding = ItemColorBinding.inflate(LayoutInflater.from(context))
        binding.root.tag = binding
        return binding
    }

}