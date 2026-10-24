package com.xromuse.app.records

import com.xromuse.app.records.SongResponse.Song


data class ArtistAllSongs(
    val success: Boolean,
    val data: Data?
) {
    
    data class Data(
        val total: Int,
        val songs: MutableList<Song?>?
    )
}
