package net.testusuke.hh.core.Ban.Listener

import net.testusuke.hh.core.Main.Companion.mode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

object PlayerDieEvent:Listener {

    @EventHandler
    fun onPlayerDie(e:PlayerDeathEvent){
        val player = e.entity
        if(!mode)return

    }

}