package com.carafax.data.cache

import android.util.Log
import com.carafax.data.entity.VehicleEntity
import rx.Observable
import javax.inject.Inject

class VehicleCacheImpl @Inject constructor(private val fileManager: FileManager, private val serializer: Serializer) : VehicleCache{

    private val defaultFileName : String = "vehicleCache"

    /**
     * Write serialised data to file cache
     * @param vehicleEntity the data to write to cache
     */
    override fun put(vehicleEntity: VehicleEntity) {
        val serializedVehicleEntity = serializer.serialize(vehicleEntity)
        val file = fileManager.buildFile(defaultFileName, "vehicle")
        serializedVehicleEntity?.let { fileManager.writeToFile(file, it) }
    }

    override fun get(): Observable<VehicleEntity> {
        return Observable.create {subscriber ->

                val file = fileManager.buildFile(defaultFileName, "vehicle")
                val fileContent = fileManager.readFileContent(file)

                try {
                    subscriber.onNext(serializer.deserialize(fileContent, VehicleEntity::class.java))
                }
                catch (e : Exception){
                    subscriber.onError(e)
                }
             }
    }


    override fun isCached(cacheId: String): Boolean {
        val file = fileManager.buildFile(defaultFileName, cacheId)
        return file.exists()
    }

}