package com.SchoolProjectIDM.Project.repo

import com.SchoolProjectIDM.Project.model.Prato
import org.springframework.stereotype.Repository

@Repository
public class RepoPrato {
    val allPratos = mutableListOf<Prato>()

    init {
        val prato1 = Prato(1, "Frango à brás", 12.49)
        val prato2 = Prato(2, "Bacalhau à brás", 16.99)
        allPratos.add(prato1)
        allPratos.add(prato2)
    }

    fun showPratos () : List<Prato>{
         return allPratos
    }

    fun addPrato (newPrato: Prato): String{
        allPratos.add(newPrato)
        return "${newPrato.nome} Adicionado com sucesso."
    }

    fun findPrato (id: Int): Prato?{
        return allPratos.find { it.id == id }
    }

    fun deletePrato(id: Int): List<Prato> {
        var prato: Prato? = findPrato(id)
        allPratos.remove(prato)
        return allPratos
    }
}