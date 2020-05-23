package net.testusuke.hh.core.Records

import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object RecordBlocks {

    fun run (player: Player){
        if(!RecordAction.value()){
            RecordAction.cannotUse(player)
            return
        }
        val effect = PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,20*20,50)
        player.addPotionEffect(effect)
    }

}