package br.com.byteabyte.cicloviewapp

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {
    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Prefs.setString("FB_TOKEN", token!!)
        Log.d("firebase", token!!)

    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage?) {

        if(mensagemRemota?.notification != null){
            val titulo = mensagemRemota?.notification?.title
            val corpo = mensagemRemota?.notification?.body

            if (titulo != null) {
                Log.d("firebase", titulo)
            }
            if (corpo != null) {
                Log.d("firebase", corpo)
            }
            showNotification(mensagemRemota)


        }
        if(mensagemRemota?.data!!.isNotEmpty()){
            val dado = mensagemRemota?.data!!.get("id")

        }
    }

    private fun showNotification(mensagemRemota: RemoteMessage?) {
        val intent = Intent(this, PecasActivity::class.java)
        val titulo = mensagemRemota?.notification?.title
        val corpo = mensagemRemota?.notification?.body

        NotificationUtil.create(1, intent, titulo!!, corpo!!)
    }
}