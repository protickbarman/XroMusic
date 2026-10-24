package com.xromuse.app.model

import com.xromuse.app.utils.TextParserUtil


data class ArtistItem(
    val name: String?,
    val image: String?,
    val id: String?
) {
    fun name(): String {
        return TextParserUtil.parseHtmlText(name)
    }
}
