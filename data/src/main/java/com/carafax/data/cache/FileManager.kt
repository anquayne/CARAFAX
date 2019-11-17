package com.carafax.data.cache

import android.content.Context
import android.util.Log
import java.io.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Helper class to do operations on regular files/directories.
 */
@Singleton
class FileManager @Inject constructor(val context : Context) {


    /**
     * Builds a file to be inserted into disk cache
     * @param defaultFileName
     * @param fileID
     * @return
     */
    fun buildFile(defaultFileName: String, fileID: String): File {

        return File(context.cacheDir.path, defaultFileName + fileID)
        /*if (!file.exists()) {
            try {
                file.createNewFile()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return file
        */
    }

    /**
     * Writes a file to Disk.
     * @param file The file to write to Disk.
     */
    fun writeToFile(file: File, fileContent: String) {
        try {
            val writer = FileWriter(file)
            writer.write(fileContent)
            writer.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {

        }
    }

    /**
     * Reads a content from a file.
     * @param file The file to read from.
     * @return A string with the content of the file.
     */
    fun readFileContent(file: File): String {
        val fileContentBuilder = StringBuilder()
        if (file.exists()) {
            var stringLine: String?=null
            try {
                val fileReader = FileReader(file)
                val bufferedReader = BufferedReader(fileReader)
                while ( bufferedReader.readLine().let { stringLine=it; stringLine!=null }) {
                    fileContentBuilder.append(stringLine + "\n")
                }
                bufferedReader.close()
                fileReader.close()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

        return fileContentBuilder.toString()
    }

}
