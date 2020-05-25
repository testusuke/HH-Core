package net.testusuke.hh.core.Records

import org.bukkit.Sound
import org.bukkit.entity.Player
import java.util.concurrent.ThreadLocalRandom

object RecordAction {

    fun cannotUse(player:Player){
        player.playSound(player.location, Sound.BLOCK_GLASS_BREAK,1F,2F)
    }

    fun value():Boolean{
        var b = false
        val r = ThreadLocalRandom.current().nextInt(1,10)
        if(r == 1 || r == 2 || r == 3 || r == 4){
            b = true
        }
        return b
    }
}