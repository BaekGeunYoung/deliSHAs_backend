package com.primavera.delishas.service.restaurantInfo

import com.primavera.delishas.domain.RestaurantInfo
import com.primavera.delishas.exception.RestaurantInfoNotFoundException
import com.primavera.delishas.repostiory.RestaurantInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RestaurantInfoServiceImpl(
        @Autowired val restaurantInfoRepository: RestaurantInfoRepository
): RestaurantInfoService{
    override fun create(restaurantInfo: RestaurantInfo): RestaurantInfo {
        return restaurantInfoRepository.save(restaurantInfo)
    }

    override fun getAll(): List<RestaurantInfo> {
        val restaurantInfos = restaurantInfoRepository.findAll()
        if(restaurantInfos.isEmpty()) throw RestaurantInfoNotFoundException("can not find any restaurant info.")
        return restaurantInfos
    }

    override fun getByName(name: String): RestaurantInfo {
        val restaurantInfo = restaurantInfoRepository.findByName(name)
        restaurantInfo?: throw RestaurantInfoNotFoundException("can not find restaurant info $name")
        return restaurantInfo
    }

    override fun getById(id: Long): RestaurantInfo {
        val restaurantInfo = restaurantInfoRepository.findById(id)
        if(!restaurantInfo.isPresent) throw RestaurantInfoNotFoundException("can not find restaurant info $id")
        return restaurantInfo.get()
    }

    override fun deleteAll() {
        restaurantInfoRepository.deleteAll()
    }

    override fun deleteByName(name: String) {
        restaurantInfoRepository.deleteByName(name)
    }

    override fun deleteById(id: Long) {
        restaurantInfoRepository.deleteById(id)
    }
}