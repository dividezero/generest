package com.hazlanrozaimi.generest.services

import com.hazlanrozaimi.generest.domains.GenericData
import com.hazlanrozaimi.generest.repositories.GenericRepository
import org.springframework.stereotype.Service

@Service
class GenericStoreService(private val genericRepository: GenericRepository) {

    fun getData(entity: String, id: Int): GenericData? {
        return genericRepository.getData(entity, id)
    }

    fun removeData(entity: String, id: Int): GenericData? {
        return genericRepository.removeData(entity, id)
    }

    fun getByEntity(entity: String): HashMap<Int, String>? {
        return genericRepository.getByEntity(entity)
    }

    fun storeData(entity: String, id: Int?, data: String): GenericData {
        return genericRepository.saveData(entity, id, data)
    }
}
