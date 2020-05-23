package net.testusuke.hh.core.Records

import org.bukkit.Sound
import org.bukkit.entity.Player

object RecordAction {

    fun cannotUse(player:Player){
        player.playSound(player.location, Sound.BLOCK_GLASS_BREAK,1F,2F)
    }

    fun value():Boolean{
        var b = false

        return b
    }
}