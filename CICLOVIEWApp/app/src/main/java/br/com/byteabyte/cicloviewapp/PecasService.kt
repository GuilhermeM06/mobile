package br.com.byteabyte.cicloviewapp

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.Response
import java.net.URL

object PecasService {

    val host = "https://gdotnot.pythonanywhere.com"
    val TAG = "WS_CICLOVIEWAPP"

    fun getPecas(context: Context): List<Pecas> {

        val url = "$host/pecas"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)
        val pecas = parserJson<List<Pecas>>(json)


        return pecas

    }

    fun savePeca(peca: Pecas) {
        val url = "$host/pecas"
        val jsonPecas = GsonBuilder().create().toJson(peca)
        HttpHelper.post(url, jsonPecas)


    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

}