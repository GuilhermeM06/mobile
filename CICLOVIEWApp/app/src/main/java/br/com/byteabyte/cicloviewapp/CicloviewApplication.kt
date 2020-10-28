package br.com.byteabyte.cicloviewapp

import android.app.Application
import java.lang.IllegalStateException

class CicloviewApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: CicloviewApplication? = null
        fun getInstance(): CicloviewApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application no AndroidManifest")
            }
            return appInstance!!
        }
    }
}