package com.facebook.reels_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class VideoAdapter(private val videoItems: List<VideoItem>) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    class VideoViewHolder(val exoPlayerView: StyledPlayerView) : RecyclerView.ViewHolder(exoPlayerView) {
        val exoPlayer: ExoPlayer = ExoPlayer.Builder(exoPlayerView.context).build()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val exoPlayerView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_video, parent, false) as StyledPlayerView
        return VideoViewHolder(exoPlayerView)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val mediaItem = MediaItem.fromUri(videoItems[position].videoUrl)

        // Set the player to the PlayerView
        holder.exoPlayerView.player = holder.exoPlayer

        // Clear any previous media items and set the new one
        holder.exoPlayer.clearMediaItems()
        holder.exoPlayer.setMediaItem(mediaItem)

        // Prepare and play the video
        holder.exoPlayer.prepare()
        holder.exoPlayer.play()
    }

    override fun getItemCount(): Int = videoItems.size

    // Release the ExoPlayer instances when the adapter is detached from the RecyclerView
    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        for (i in 0 until itemCount) {
            val viewHolder = recyclerView.findViewHolderForAdapterPosition(i) as? VideoViewHolder
            viewHolder?.exoPlayer?.release()
        }
    }
}
