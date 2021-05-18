package com.SchoolProjectIDM.Project.repo

import com.SchoolProjectIDM.Project.model.Orders
import com.SchoolProjectIDM.Project.model.Prato

class RepoOrders {
    val allOrders = mutableListOf<Orders>()

    init {
        val order1 = Orders(1, "Frango à brás", "Gonçalo", "Avenida Dom Dinis, 17", false)
        val order2 = Orders(2, "Bacalhau à brás", "Johnny", "Avenida Dom Dinis, 19", false)
        allOrders.add(order1)
        allOrders.add(order2)
    }

    fun showOrders () : List<Orders>{
        return allOrders
    }

    fun update (id: Int) : String {
        var order = findOrder(id);
        order?.foiEntregue = true;
        return "Atualizado: " + order
    }

    fun addOrder (newOrder: Orders): String{
        allOrders.add(newOrder)
        return "Encomenda Adicionada com sucesso."
    }

    fun findOrder (id: Int): Orders?{
        return allOrders.find { it.id.equals(id) }
    }

    fun findOrderStatus (id: Int): String{
        var order = allOrders.find { it.id.equals(id) }
        var status = order?.foiEntregue
        return "Status: " + status
    }

    fun deleteOrder(id: Int): List<Orders> {
        allOrders.remove(findOrder(id))
        return allOrders
    }
}