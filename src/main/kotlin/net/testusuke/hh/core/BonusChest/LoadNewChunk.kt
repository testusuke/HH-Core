package net.testusuke.hh.core.BonusChest

import net.testusuke.hh.core.Main.Companion.mode
import net.testusuke.hh.core.Main.Companion.moduleData
import net.testusuke.hh.core.Main.Companion.plugin
import org.bukkit.Location
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.world.ChunkPopulateEvent

object LoadNewChunk: Listener {

    @EventHandler
    fun onChunkPopulate(event:ChunkPopulateEvent){
        if(!mode)return
        if(!moduleData.bonusChestMode)return
        val chunk = event.chunk
        val world = chunk.world
        if(world.name != moduleData.bonusChestWorld)return
        val x = chunk.x
        val z = chunk.z
        val location = Location(world,x.toDouble(),world.getHighestBlockYAt(x,z).toDouble(),z.toDouble())
        //  CreateChest
        createChest(location)
    }

    fun createChest(location:Location){

    }
}
