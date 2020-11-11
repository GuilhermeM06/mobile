package br.com.byteabyte.cicloviewapp

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.common.util.Strings
import java.security.Permissions

object PermissionUtils {

    fun validate(activity: Activity, requestCode: Int, vararg permissions: String): Boolean {
        val list = ArrayList<String>()

        for (p in permissions) {
            val ok = ContextCompat.checkSelfPermission(activity, p) == PackageManager.PERMISSION_GRANTED

            if (!ok){
                list.add(p)
            }
        }
        if (list.isEmpty()) return true

        val newP = arrayOfNulls<String>(list.size)
        list.toArray(newP)
        ActivityCompat.requestPermissions(activity, newP, requestCode)
        return false
    }
}