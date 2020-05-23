package net.testusuke.hh.core.Records

import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object RecordMall {

    fun run(player: Player){
        if(!RecordAction.value()){
            RecordAction.cannotUse(player)
            return
        }
        val effect = PotionEffect(PotionEffectType.SLOW,20 * 20,1)
        player.addPotionEffect(effect)
    }
}