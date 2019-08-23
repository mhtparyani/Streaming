package com.shera.internexttv.gui.dialogs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.SendChannel
import com.shera.internexttv.databinding.SubtitleDownloadItemBinding

internal class SubtitlesAdapter(private val eventActor: SendChannel<SubtitleEvent>) : RecyclerView.Adapter<SubtitlesAdapter.ViewHolder>() {
    private var dataset: List<SubtitleItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubtitlesAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SubtitleDownloadItemBinding.inflate(inflater, parent, false )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset?.get(position)
        holder.bind(item)
    }

    fun setList(list: List<SubtitleItem>?) {
        dataset = list
        notifyDataSetChanged()
    }

    override fun getItemCount() = dataset?.size ?: 0

    @ExperimentalCoroutinesApi
    inner class ViewHolder(val binding: SubtitleDownloadItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener, View.OnLongClickListener {

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View) {
            dataset?.get(layoutPosition)?.let {
                if(!eventActor.isClosedForSend)
                    eventActor.offer(Click(it)) }
        }

        override fun onLongClick(v: View): Boolean {
            dataset?.get(layoutPosition)?.let {
                if(!eventActor.isClosedForSend)
                    eventActor.offer(LongClick(it))
            }
            return true
        }


        fun bind(subtitleItem: SubtitleItem?) {
            binding.subtitleItem = subtitleItem
            binding.executePendingBindings()
        }
    }
}

sealed class SubtitleEvent
class Click(val item: SubtitleItem) : SubtitleEvent()
class LongClick(val item: SubtitleItem) : SubtitleEvent()
