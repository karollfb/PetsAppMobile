package br.com.petsappmobile.util

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream

fun bitmapToBase64(bitmap: Bitmap): String {

    //criando um fluxo de saída - array de bytes
    val byteArrayOutputStream = ByteArrayOutputStream()

    //comprimindo o bitmap e colocando os bytes no fluxo de saída (byteArrayOutputStream)
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)

    //convertendo o fluxo de bytes em um array de bytes
    val imagemArray = byteArrayOutputStream.toByteArray()

    //convertendo a imagem em base64
    val imagemBase64 = Base64.encodeToString(imagemArray, Base64.NO_WRAP)

    return imagemBase64
}