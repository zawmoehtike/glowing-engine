package co.codigo.tmdbexample.data.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
{
    "adult": false,
    "backdrop_path": "/fOy2Jurz9k6RnJnMUMRDAgBwru2.jpg",
    "belongs_to_collection": null,
    "budget": 190000000,
    "genres": [
        {
            "id": 16,
            "name": "Animation"
        },
        {
            "id": 10751,
            "name": "Family"
        },
        {
            "id": 35,
            "name": "Comedy"
        },
        {
            "id": 14,
            "name": "Fantasy"
        }
    ],
    "homepage": "https://www.disneyplus.com/movies/turning-red/4mFPCXJi7N2m",
    "id": 508947,
    "imdb_id": "tt8097030",
    "original_language": "en",
    "original_title": "Turning Red",
    "overview": "Thirteen-year-old Mei is experiencing the awkwardness of being a teenager with a twist – when she gets too excited, she transforms into a giant red panda.",
    "popularity": 8443.122,
    "poster_path": "/qsdjk9oAKSQMWs0Vt5Pyfh6O4GZ.jpg",
    "production_companies": [
        {
            "id": 2,
            "logo_path": "/wdrCwmRnLFJhEoH8GSfymY85KHT.png",
            "name": "Walt Disney Pictures",
            "origin_country": "US"
        },
        {
            "id": 3,
            "logo_path": "/1TjvGVDMYsj6JBxOAkUHpPEwLf7.png",
            "name": "Pixar",
            "origin_country": "US"
        }
    ],
    "production_countries": [
        {
            "iso_3166_1": "US",
            "name": "United States of America"
        }
    ],
    "release_date": "2022-03-10",
    "revenue": 0,
    "runtime": 100,
    "spoken_languages": [
        {
            "english_name": "Cantonese",
            "iso_639_1": "cn",
            "name": "广州话 / 廣州話"
        },
        {
            "english_name": "Mandarin",
            "iso_639_1": "zh",
            "name": "普通话"
        },
        {
            "english_name": "English",
            "iso_639_1": "en",
            "name": "English"
        },
        {
            "english_name": "French",
            "iso_639_1": "fr",
            "name": "Français"
        },
        {
            "english_name": "Korean",
            "iso_639_1": "ko",
            "name": "한국어/조선말"
        }
    ],
    "status": "Released",
    "tagline": "Growing up is a beast.",
    "title": "Turning Red",
    "video": false,
    "vote_average": 7.5,
    "vote_count": 1012
}
 */
class MovieDetailResponse: BaseResponse() {
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("overview")
    @Expose
    var overview: String? = null
    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String? = null
    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null
}