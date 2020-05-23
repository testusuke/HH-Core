package net.testusuke.hh.core.Listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object WitherEffectEvent: Listener {

    @EventHandler
    fun onPlayerMove(event:PlayerMoveEvent){
        val player = event.player
        val location = player.location
        if(location.y > 300){
            val effect = PotionEffect(PotionEffectType.WITHER,9999 * 20,2)
            player.addPotionEffect(effect)
        }
    }

}