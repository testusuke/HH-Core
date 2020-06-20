package net.testusuke.hh.core.BonusChest

import net.testusuke.hh.core.Main.Companion.mode
import net.testusuke.hh.core.Main.Companion.moduleData
import net.testusuke.hh.core.Main.Companion.plugin
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.Chest
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.world.ChunkPopulateEvent
import org.bukkit.inventory.ItemStack
import kotlin.random.Random

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
        val location = Location(world,x.toDouble(),world.getHighestBlockYAt(x,z).toDouble() + 1,z.toDouble())
        //  確率
        if(!value())return
        //  CreateChest
        createChest(location)
    }

    private fun createChest(location:Location) {
        location.block.type = Material.CHEST
        val chest = location.block.blockData as Chest
        val inv = chest.inventory

    }

    private fun value():Boolean{
        val rand = (1..100).shuffled().first()
        if(rand <= moduleData.bonusChestValue){
            return true
        }
        return false
    }
}
