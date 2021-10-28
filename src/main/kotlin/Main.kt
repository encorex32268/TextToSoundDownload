import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.net.URL

fun main() {

    val word = "ashitaharerukana"
    val urlString = "https://translate.google.com/translate_tts?ie=UTF-8&tl=ja-JP&client=tw-ob&q=$word"
    val url = URL(urlString)
    val httpURLConnection = url.openConnection().apply {
        addRequestProperty("User-Agent", "Mozilla/5.0")
    }
    val inputStream = httpURLConnection.getInputStream()
    val outstream: OutputStream = FileOutputStream(File("mysound.mp3"))
    val buffer = ByteArray(4096)
    var len: Int
    while (inputStream.read(buffer).also { len = it } > 0) {
        outstream.write(buffer, 0, len)
    }
    outstream.close()

}