package net.testusuke.hh.core.Records

import org.bukkit.entity.Player

object Record11 {

    fun run(player: Player){
        if(!RecordAction.value()){
            RecordAction.cannotUse(player)
            return
        }

    }
}