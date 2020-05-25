package net.testusuke.hh.core.Listener

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object DrinkMilkEvent:Listener {

    @EventHandler
    fun onDrinkMilk(event:PlayerItemConsumeEvent){
        val player = event.player
        val item = event.item
        if(item.type == Material.MILK_BUCKET){
            event.isCancelled = true
            item.amount--
            val effect = PotionEffect(PotionEffectType.HUNGER,30 * 20,3)
            player.addPotionEffect(effect)
        }
    }
}