package com.shera.internexttv.api
import com.squareup.moshi.Json

data class OpenSubtitle(
        @field:Json(name = "MatchedBy") val matchedBy: String,
        @field:Json(name = "IDSubMovieFile") val idSubMovieFile: String,
        @field:Json(name = "MovieHash") val movieHash: String,
        @field:Json(name = "MovieByteSize") val movieByteSize: String,
        @field:Json(name = "MovieTimeMS") val movieTimeMS: String,
        @field:Json(name = "IDSubtitleFile") val idSubtitleFile: String,
        @field:Json(name = "SubFileName") val subFileName: String,
        @field:Json(name = "SubActualCD") val subActualCD: String,
        @field:Json(name = "SubSize") val subSize: String,
        @field:Json(name = "SubHash") val subHash: String,
        @field:Json(name = "SubLastTS") val subLastTS: String,
        @field:Json(name = "SubTSGroup") val subTSGroup: String,
        @field:Json(name = "InfoReleaseGroup") val infoReleaseGroup: String,
        @field:Json(name = "InfoFormat") val infoFormat: String,
        @field:Json(name = "InfoOther") val infoOther: String,
        @field:Json(name = "IDSubtitle") val idSubtitle: String,
        @field:Json(name = "UserID") val userID: String,
        @field:Json(name = "SubLanguageID") val subLanguageID: String,
        @field:Json(name = "SubFormat") val subFormat: String,
        @field:Json(name = "SubSumCD") val subSumCD: String,
        @field:Json(name = "SubAuthorComment") val subAuthorComment: String,
        @field:Json(name = "SubAddDate") val subAddDate: String,
        @field:Json(name = "SubBad") val subBad: String,
        @field:Json(name = "SubRating") val subRating: String,
        @field:Json(name = "SubSumVotes") val subSumVotes: String,
        @field:Json(name = "SubDownloadsCnt") val subDownloadsCnt: String,
        @field:Json(name = "MovieReleaseName") val movieReleaseName: String,
        @field:Json(name = "MovieFPS") val movieFPS: String,
        @field:Json(name = "IDMovie") val idMovie: String,
        @field:Json(name = "IDMovieImdb") val idMovieImdb: String,
        @field:Json(name = "MovieName") val movieName: String,
        @field:Json(name = "MovieNameEng") val movieNameEng: Any,
        @field:Json(name = "MovieYear") val movieYear: String,
        @field:Json(name = "MovieImdbRating") val movieImdbRating: Any,
        @field:Json(name = "SubFeatured") val subFeatured: String,
        @field:Json(name = "UserNickName") val userNickName: String,
        @field:Json(name = "SubTranslator") val subTranslator: String,
        @field:Json(name = "ISO639") val iSO639: String,
        @field:Json(name = "LanguageName") val languageName: String,
        @field:Json(name = "SubComments") val subComments: String,
        @field:Json(name = "SubHearingImpaired") val subHearingImpaired: String,
        @field:Json(name = "UserRank") val userRank: String,
        @field:Json(name = "SeriesSeason") val seriesSeason: String,
        @field:Json(name = "SeriesEpisode") val seriesEpisode: String,
        @field:Json(name = "MovieKind") val movieKind: String,
        @field:Json(name = "SubHD") val subHD: String,
        @field:Json(name = "SeriesIMDBParent") val seriesIMDBParent: String,
        @field:Json(name = "SubEncoding") val subEncoding: String,
        @field:Json(name = "SubAutoTranslation") val subAutoTranslation: String,
        @field:Json(name = "SubForeignPartsOnly") val subForeignPartsOnly: String,
        @field:Json(name = "SubFromTrusted") val subFromTrusted: String,
        @field:Json(name = "QueryParameters") val queryParameters: QueryParameters,
        @field:Json(name = "SubTSGroupHash") val subTSGroupHash: String,
        @field:Json(name = "SubDownloadLink") val subDownloadLink: String,
        @field:Json(name = "ZipDownloadLink") val zipDownloadLink: String,
        @field:Json(name = "SubtitlesLink") val subtitlesLink: String,
        @field:Json(name = "QueryNumber") val queryNumber: String,
        @field:Json(name = "Score") val score: Double
)

data class QueryParameters(
        @field:Json(name = "query") val query: String,
        @field:Json(name = "episode") val episode: String,
        @field:Json(name = "season") val season: String
)

