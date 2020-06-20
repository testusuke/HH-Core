package net.testusuke.hh.core.Listener

import net.testusuke.hh.core.Main.Companion.mode
import net.testusuke.hh.core.Main.Companion.moduleData
import net.testusuke.hh.core.Records.*
import org.bukkit.Material
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
            when(material){
                Material.MUSIC_DISC_11 -> RecordAction.Record11.run(player)
                Material.MUSIC_DISC_13 -> RecordAction.Record13.run(player)
                Material.MUSIC_DISC_BLOCKS -> RecordAction.RecordBlocks.run(player)
                Material.MUSIC_DISC_CAT -> RecordAction.RecordCat.run(player)
                Material.MUSIC_DISC_CHIRP -> RecordAction.RecordChirp.run(player)
                Material.MUSIC_DISC_FAR -> RecordAction.RecordFar.run(player)
                Material.MUSIC_DISC_MALL -> RecordAction.RecordMall.run(player)
                Material.MUSIC_DISC_MELLOHI -> RecordAction.RecordMellohi.run(player)
                Material.MUSIC_DISC_STAL -> RecordAction.RecordStal.run(player)
                Material.MUSIC_DISC_STRAD -> RecordAction.RecordStrad.run(player)
                Material.MUSIC_DISC_WAIT -> RecordAction.RecordWait.run(player)
                Material.MUSIC_DISC_WARD -> RecordAction.RecordWard.run(player)
                else -> return
            }
            item.amount--

        }
    }
}