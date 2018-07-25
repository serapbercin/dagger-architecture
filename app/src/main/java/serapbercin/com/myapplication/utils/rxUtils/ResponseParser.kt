package serapbercin.com.myapplication.utils.rxUtils

import okhttp3.ResponseBody
import org.json.JSONObject


class ResponseParser {

	fun errorResponseParser(responseBody: ResponseBody?): Error {
		val jsonObject = JSONObject(responseBody!!.string())
		return Error(jsonObject.getString("message"), jsonObject.optString("documentation_url"))
	}

	open class Error(val errorType: String, val context: String?)

}