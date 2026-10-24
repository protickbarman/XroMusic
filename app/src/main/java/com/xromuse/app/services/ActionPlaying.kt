package com.xromuse.app.services

interface ActionPlaying {
    fun nextClicked()
    fun prevClicked()
    fun playClicked()
    fun onProgressChanged(progress: Int)
}
