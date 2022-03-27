package co.codigo.tmdbexample.data.responses

import co.codigo.tmdbexample.data.networkvos.MovieVO
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
{
    "dates": {
        "maximum": "2022-04-18",
        "minimum": "2022-04-01"
    },
    "page": 1,
    "results": [
        {
            "adult": false,
            "backdrop_path": "/tq3klWQevRK0Or0cGhsw0h3FDWQ.jpg",
            "genre_ids": [
                12,
                16,
                35,
                10751,
                14
            ],
            "id": 676705,
            "original_language": "fr",
            "original_title": "Pil's Adventures",
            "overview": "Pil, a little vagabond girl, lives on the streets of the medieval city of Roc-en-Brume, along with her three tame weasels. She survives of food stolen from the castle of the sinister Regent Tristain. One day, to escape his guards, Pil disguises herself as a princess. Thus she embarks upon a mad, delirious adventure, together with Crobar, a big clumsy guard who thinks she's a noble, and Rigolin, a young crackpot jester. Pil is going to have to save Roland, rightful heir to the throne under the curse of a spell. This adventure will turn the entire kingdom upside down, and teach Pil that nobility can be found in all of us.",
            "popularity": 2426.316,
            "poster_path": "/xy6wQ09rMIN2FfWPHJXCWyRZ3P9.jpg",
            "release_date": "2021-08-11",
            "title": "Pil's Adventures",
            "video": false,
            "vote_average": 7.4,
            "vote_count": 24
        }
    ]
}
 */
class PopularResponse: BaseResponse() {
    @SerializedName("results")
    @Expose
    var results: List<MovieVO>? = ArrayList(0)
}