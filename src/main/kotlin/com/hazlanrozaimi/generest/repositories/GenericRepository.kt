package com.hazlanrozaimi.generest.repositories

import com.hazlanrozaimi.generest.domains.GenericData
import org.springframework.stereotype.Component

@Component
class GenericRepository {

    val store: HashMap<String, HashMap<Int, String>> = HashMap()

    fun getNewId(entity: String): Int {
        val entityStore = store[entity] ?: return 0

        val keyList = ArrayList(entityStore.keys)

        var max = 0
        for (key in keyList) {
            if (key > max)
                max = key
        }
        return max + 1
    }

    fun getData(entity: String, id: Int): GenericData? {
        val entityStore = store[entity]
        var result: GenericData? = null

        if (entityStore != null && entityStore[id] != null) {
            result = GenericData(entity, id, entityStore[id])
        }
        return result
    }

    fun getByEntity(entity: String): HashMap<Int, String>? {
        return store[entity]
    }

    fun saveData(entity: String, id: Int?, data: String): GenericData {
        var entityStore = store[entity]
        var itemId: Int? = id

        if (id == null) {
            itemId = getNewId(entity)
        }
        if (entityStore != null) {
            entityStore[itemId!!] = data
        } else {
            entityStore = hashMapOf(itemId!! to data)
            store[entity] = entityStore
        }
        return GenericData(entity, itemId, data)
    }
}
