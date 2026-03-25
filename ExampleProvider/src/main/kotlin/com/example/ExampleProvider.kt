package com.example

import com.lagradost.cloudstream3.MainAPI
import com.lagradost.cloudstream3.TvType
import com.lagradost.cloudstream3.newMovieSearchResponse
import com.lagradost.cloudstream3.app
import com.lagradost.cloudstream3.HomePageRequest
import com.lagradost.cloudstream3.HomePageResponse
import com.lagradost.cloudstream3.newHomePageResponse

class Yanhh3DProvider : MainAPI() { 
    override var mainUrl = "https://yanhh3d.sh"
    override var name = "Yanhh3D"
    override val supportedTypes = setOf(TvType.Movie, TvType.TvSeries)

    override suspend fun getMainPage(page: Int, request: HomePageRequest): HomePageResponse {
        val document = app.get(mainUrl).document
        val home = document.select("article, .post-item").mapNotNull {
            val title = it.selectFirst(".entry-title, h2")?.text() ?: return@mapNotNull null
            val href = it.selectFirst("a")?.attr("href") ?: return@mapNotNull null
            val poster = it.selectFirst("img")?.attr("src") ?: ""
            newMovieSearchResponse(title, href, TvType.Movie) { this.posterUrl = poster }
        }
        return newHomePageResponse("Phim Mới", home)
    }
}
