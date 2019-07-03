package com.hazlanrozaimi.generest.repositories

import com.hazlanrozaimi.generest.domains.GenericData
import org.springframework.stereotype.Component

@Component
class GenericRepository {

    val store: HashMap<String, HashMap<Int, String>> = HashMap()

    fun getData(entity: String, id: Int): GenericData? {
        val entityStore = store[entity]
        var result: GenericData? = null

        if (entityStore != null && entityStore[id] != null) {
            result = GenericData(entity, id, entityStore[id])
        }
        return result
    }

    fun saveData(entity: String, id: Int, data: String): GenericData {
        var entityStore = store[entity]
        if (entityStore != null) {
            entityStore[id] = data
        } else {
            entityStore = hashMapOf(id to data)
            store[entity] = entityStore
        }
        return GenericData(entity, id, data)
    }
}
