package com.SchoolProjectIDM.Project.model.controller

import com.SchoolProjectIDM.Project.model.Orders
import com.SchoolProjectIDM.Project.model.Prato
import com.SchoolProjectIDM.Project.repo.RepoOrders
import com.SchoolProjectIDM.Project.repo.RepoPrato
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController {

    var repo = RepoPrato()
    var repoOrder = RepoOrders()

    @GetMapping(value = ["/getMenu"])
    fun getPratos(): List<Prato>{
        return repo.showPratos()
    }

    @PostMapping(value = ["/addMenu"])
    fun CreatePrato(@RequestBody prato: Prato): String {
        repo.addPrato(prato)
        return "Foi adicionado o Prato ${prato.nome} com o id ${prato.id}"
    }

    @PostMapping(value = ["/order"])
    fun createOrder(@RequestBody orders: Orders): String{
        return repoOrder.addOrder(orders)
    }

    @GetMapping(value = ["/cancelOrder/{id}"])
    fun cancelOrder(@PathVariable id: Int): List<Orders> {
        return repoOrder.deleteOrder(id)
    }

    @GetMapping(value = ["/updateOrder/{id}"])
    fun updateOrder(@PathVariable id: Int): String{
        return repoOrder.update(id)
    }

    @GetMapping(value = ["/delMenu/{id}"])
    fun delMenu(@PathVariable id: Int): String{
        return repo.deletePrato(id).toString()
    }

    @GetMapping(value = ["/statusOrder/{id}"])
    fun find(@PathVariable id: Int): String{
        return "" + repoOrder.findOrderStatus(id)
    }


}