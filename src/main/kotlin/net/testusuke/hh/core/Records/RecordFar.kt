package net.testusuke.hh.core.Records

import org.bukkit.Bukkit
import org.bukkit.entity.Player

object RecordFar {

    fun run(player: Player){
        if(!RecordAction.value()){
            RecordAction.cannotUse(player)
            return
        }
        //  Command
        Bukkit.dispatchCommand(player,"spawn")

    }
}