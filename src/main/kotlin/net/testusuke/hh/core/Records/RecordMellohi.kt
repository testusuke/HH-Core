package net.testusuke.hh.core.Records

import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object RecordMellohi {
    fun run(player: Player){
        if(!RecordAction.value()){
            RecordAction.cannotUse(player)
            return
        }
        val effect = PotionEffect(PotionEffectType.SPEED,20 * 20,3)
        for(entity in player.getNearbyEntities(3.0,3.0,3.0)){
            if(entity is Player) {
                entity.addPotionEffect(effect)
            }
        }
        player.addPotionEffect(effect)
    }
}