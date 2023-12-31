package com.yourbynn.matchingjob.Utils

import android.content.Context
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder

object MessageUtils {
    fun showToast(context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun showDialog(context: Context, message: String){
        MaterialAlertDialogBuilder(context)
            .setTitle("Error")
            .setMessage(message)
            .setPositiveButton("Oke"){ dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

}