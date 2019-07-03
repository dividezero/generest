package com.hazlanrozaimi.generest.controllers

import com.hazlanrozaimi.generest.domains.GenericData
import com.hazlanrozaimi.generest.services.GenericStoreService
import org.springframework.web.bind.annotation.*


@RestController
class GenericController(private val genericStoreService: GenericStoreService) {

    @PutMapping("/{entity}/{id}")
    fun putStore(@PathVariable(value = "entity") entity: String, @PathVariable(value = "id") id: String, @RequestBody body: String): GenericData {
        return genericStoreService.storeData(entity, id.toInt(), body)
    }

    @DeleteMapping("/{entity}/{id}")
    fun deleteStore(@PathVariable(value = "entity") entity: String, @PathVariable(value = "id") id: String): GenericData? {
        return genericStoreService.removeData(entity, id.toInt())
    }

    @PostMapping("/{entity}")
    fun postStore(@PathVariable(value = "entity") entity: String, @RequestBody body: String): GenericData {
        return genericStoreService.storeData(entity, null, body)
    }

    @GetMapping("/{entity}/{id}")
    fun getStore(@PathVariable(value = "entity") entity: String, @PathVariable(value = "id") id: String): GenericData? {
        return genericStoreService.getData(entity, id.toInt())
    }

    @GetMapping("/{entity}")
    fun getStore(@PathVariable(value = "entity") entity: String): HashMap<Int, String>? {
        return genericStoreService.getByEntity(entity)
    }

}
