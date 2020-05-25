package net.testusuke.hh.core.Records

import net.testusuke.hh.core.Main.Companion.plugin
import org.bukkit.Bukkit
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.util.Vector

object RecordFar {

    fun run(player: Player){
        if(!RecordAction.value()){
            RecordAction.cannotUse(player)
            return
        }
        for(entity in player.getNearbyEntities(3.0,3.0,3.0)) {
            if(entity is Player) {
                //  Command
                Bukkit.dispatchCommand(entity, "spawn")
                continue
            }
            //  落下ダメージ
            damage(entity)
        }
        Bukkit.dispatchCommand(player,"spawn")
    }

    private fun damage(entity: Entity){
        object : BukkitRunnable(){
            override fun run(){
                val vector = Vector(0,2,0)
                entity.velocity = vector
                Thread.sleep(500)
                entity.velocity = Vector()
            }
        }.runTaskAsynchronously(plugin)

    }

}