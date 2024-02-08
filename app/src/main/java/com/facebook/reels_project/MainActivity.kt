package com.facebook.reels_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.reels_project.databinding.ActivityMainBinding
import com.google.android.exoplayer2.ExoPlayer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var videoAdapter: VideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoItems = listOf(
            VideoItem("https://storage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
            VideoItem("https://storage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
            VideoItem("https://storage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
            VideoItem("https://storage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
            VideoItem("https://storage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
            // Add more VideoItems as needed
        )

        videoAdapter = VideoAdapter(videoItems)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = videoAdapter
        }
    }
}
