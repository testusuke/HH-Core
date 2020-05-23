package net.testusuke.hh.core.Listener

import net.testusuke.hh.core.Main.Companion.mode
import net.testusuke.hh.core.Main.Companion.moduleData
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

object RecordEvent:Listener {

    @EventHandler
    fun onUseRecord(event:PlayerInteractEvent){
        if(event.action == Action.RIGHT_CLICK_BLOCK || event.action == Action.RIGHT_CLICK_AIR) {
            if (!mode) return
            if (!moduleData.recordMode) return
            val player = event.player
            if (!event.hasItem()) return
            val item = event.item
            if (item == null || item.type.isAir) return
            val material = item.type
            if (!material.isRecord) return
            when(material.name){

            }
        }
    }
}