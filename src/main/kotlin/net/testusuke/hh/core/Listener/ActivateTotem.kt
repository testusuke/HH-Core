package net.testusuke.hh.core.Listener

import net.minecraft.server.v1_15_R1.PacketPlayOutEntityStatus
import net.testusuke.hh.core.Main.Companion.moduleData
import net.testusuke.hh.core.Main.Companion.plugin
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.scheduler.BukkitRunnable
import java.util.concurrent.ThreadLocalRandom

object ActivateTotem:Listener {

    @EventHandler
    fun onHasTotem(event:EntityDamageEvent){
        val player = event.entity
        if(player !is Player)return
        if(player.gameMode == GameMode.CREATIVE)return
        if(player.inventory.contains(Material.TOTEM_OF_UNDYING) || player.inventory.itemInOffHand.type == Material.TOTEM_OF_UNDYING){
            if(!moduleData.totemMode)return
            //  Remove
            player.inventory.remove(Material.TOTEM_OF_UNDYING)
            if(player.inventory.itemInOffHand.type == Material.TOTEM_OF_UNDYING){
                player.inventory.setItemInOffHand(ItemStack(Material.AIR))
            }
            //  NMS for activate totem animation
            val craftPlayer = player as CraftPlayer
            val entityPlayer = craftPlayer.handle
            val id:Byte = 35
            val ppoes = PacketPlayOutEntityStatus(entityPlayer, id)
            entityPlayer.playerConnection.sendPacket(ppoes)
            //  Task
            object : BukkitRunnable(){
                override fun run(){
                    //  killer
                    val location = player.location
                    val world = location.world
                    val beforeX = location.blockX
                    val y = location.blockY
                    val beforeZ = location.blockZ
                    for(i in 0..9){
                        val x = ThreadLocalRandom.current().nextDouble(-2.0,2.0)
                        val z = ThreadLocalRandom.current().nextDouble(-2.0,2.0)
                        val targetLocation = Location(world,beforeX + x, y.toDouble(),beforeZ + z)
                        world?.strikeLightning(targetLocation)
                        world?.createExplosion(targetLocation,6.0F)
                    }
                }
            }.runTaskLater(plugin,40)
        }
    }
}