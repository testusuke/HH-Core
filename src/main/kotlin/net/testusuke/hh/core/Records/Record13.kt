package net.testusuke.hh.core.Records

import org.bukkit.entity.Player

object Record13 {
    fun run(player: Player){
        player.openInventory(player.enderChest)
    }
}