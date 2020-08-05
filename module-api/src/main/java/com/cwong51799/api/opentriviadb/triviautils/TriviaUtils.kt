package com.cwong51799.api.opentriviadb.triviautils

import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import androidx.navigation.NavOptions
import com.cwong51799.api.R

/**
 * Applies formatting since the API returns some weird format for " and '
 */

object TriviaUtils {
    fun getFormattedHtmlFromString(str : String) : Spanned {
        return HtmlCompat.fromHtml(formatToHtml(str), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    private fun formatToHtml(str: String): String {
        var strCopy: String = str
        var alternator = 0
        while (strCopy.contains("&quot;")) {
            if (alternator == 0) {
                strCopy = strCopy.replaceFirst("&quot;", "<b>")
                alternator = 1
            } else {
                strCopy = strCopy.replaceFirst("&quot;", "</b>")
                alternator = 0
            }
        }
        strCopy = strCopy.replace("&#039;", "'")
        return strCopy
    }

    /**
     * Returns the query index corresponding to the category.
     * All options here should be present in the trivia_categories string array
     */
    fun getIndexOfCategory(category : String) : Int?{
        return when(category) {
            "General Knowledge" -> 9
            "Entertainment: Books" -> 10
            "Entertainment: Film" -> 11
            "Entertainment: Music" -> 12
            "Entertainment: Musicals and Theatres" -> 13
            "Entertainment: Television" -> 14
            "Entertainment: Video Games" -> 15
            "Entertainment: Board Games" -> 16
            "Science and Nature" -> 17
            "Science: Computers" -> 18
            "Science: Mathematics" -> 19
            "Mythology" -> 20
            "Sports" -> 21
            "Geography" -> 22
            "History" -> 23
            "Politics" -> 24
            "Art" -> 25
            "Celebrities" -> 26
            "Animals" -> 27
            "Comics" -> 28
            "Anime and Manga" -> 29
            "Cartoons and Animations" -> 30
            else -> null
        }
    }

    fun getOptionsWithReturnSetToFragment(fragment : Int) : NavOptions{
        return NavOptions.Builder().setPopUpTo(fragment, false).build()
    }
}