package com.nk.androidbootcamp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexboxLayout
import com.google.android.flexbox.FlexboxLayoutManager
import com.nk.androidbootcamp.databinding.ItemRecyclerBinding


class RecyclerAdapter(val count: Int) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {
    class RecyclerViewHolder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemRecyclerBinding = DataBindingUtil.inflate(inflater, R.layout.item_recycler, parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = count

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        (holder.binding.root.layoutParams as? FlexboxLayoutManager.LayoutParams)?.let {
            it.isWrapBefore = position % 7 == 0
            holder.binding.root.layoutParams = it
        }
    }
}