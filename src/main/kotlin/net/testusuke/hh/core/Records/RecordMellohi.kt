package net.testusuke.hh.core.Records

import org.bukkit.entity.Player
import org.bukkit.potion.Potion
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object RecordMellohi {
    fun run(player: Player){
        if(!RecordAction.value()){
            RecordAction.cannotUse(player)
            return
        }
        val effect = PotionEffect(PotionEffectType.SPEED,20 * 20,3)
        player.addPotionEffect(effect)
    }
}