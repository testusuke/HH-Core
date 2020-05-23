package net.testusuke.hh.core.Records

import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object RecordStal {

    fun run(player: Player){
        if(!RecordAction.value()){
            RecordAction.cannotUse(player)
            return
        }
        val effect = PotionEffect(PotionEffectType.REGENERATION,20 * 20,3)
        player.addPotionEffect(effect)
    }
}