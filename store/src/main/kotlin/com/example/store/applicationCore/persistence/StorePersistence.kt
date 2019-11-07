package com.example.store.applicationCore.persistence

import com.example.store.adapters.infrastructure.database.mongoDB.StoreRepository
import com.example.store.applicationCore.domain.model.Store
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service

@Service
class StorePersistence(val repository: StoreRepository) {
    fun save(store: Store): Store {
        return repository.save(store)
    }

    fun get(name: String?, address: String?): List<Store> {
        val query = Query()
        if (!name.isNullOrEmpty()) query.addCriteria(Criteria.where("name").`is`(name))
        if (!address.isNullOrEmpty()) query.addCriteria(Criteria.where("address").`is`(address))
        return repository.find(query)
    }

    fun update(id: String, store: Store): Store {
        val query = Query()
        query.addCriteria(Criteria.where("id").`is`(id))

        val update = Update()
        update.set("name", store.name)
        update.set("address", store.address)

        return repository.update(query, update)
    }
}