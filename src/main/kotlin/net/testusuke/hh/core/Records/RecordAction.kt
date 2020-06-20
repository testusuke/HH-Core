package net.testusuke.hh.core.Records

import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import java.util.concurrent.ThreadLocalRandom

enum class RecordAction {

    Record11{
        override fun run(player:Player){
            if(!RecordUtils.value()){
                RecordUtils.cannotUse(player)
                return
            }
        }
    },
    Record13{
        override fun run(player:Player){
            player.openInventory(player.enderChest)
        }
    },
    RecordBlocks{
        override fun run(player:Player){
            if(!RecordUtils.value()){
                RecordUtils.cannotUse(player)
                return
            }
            val effect = PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,20*20,50)
            player.addPotionEffect(effect)
        }
    },
    RecordCat{
        override fun run(player:Player){
            if(!RecordUtils.value()){
                RecordUtils.cannotUse(player)
                return
            }
        }
    },
    RecordChirp{
        override fun run(player:Player){
            if(!RecordUtils.value()){
                RecordUtils.cannotUse(player)
                return
            }
        }
    },
    RecordFar{
        override fun run(player:Player){
            if(!RecordUtils.value()){
                RecordUtils.cannotUse(player)
                return
            }
            for(entity in player.getNearbyEntities(3.0,3.0,3.0)) {
                if(entity is Player) {
                    //  Command
                    Bukkit.dispatchCommand(entity, "spawn")
                    continue
                }
                //  落下ダメージ
                RecordUtils.damage(entity)
            }
            Bukkit.dispatchCommand(player,"spawn")
        }
    },
    RecordMall{
        override fun run(player:Player){
            if(!RecordUtils.value()){
                RecordUtils.cannotUse(player)
                return
            }
            for(effect in player.activePotionEffects){
                player.removePotionEffect(effect.type)
            }
        }
    },
    RecordMellohi{
        override fun run(player:Player){
            if(!RecordUtils.value()){
                RecordUtils.cannotUse(player)
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
    },
    RecordStal{
        override fun run(player:Player){
            if(!RecordUtils.value()){
                RecordUtils.cannotUse(player)
                return
            }
            val effect = PotionEffect(PotionEffectType.REGENERATION,20 * 20,3)
            player.addPotionEffect(effect)
        }
    },
    RecordStrad{
        override fun run(player:Player){
            if(!RecordUtils.value()){
                RecordUtils.cannotUse(player)
                return
            }
        }
    },
    RecordWait{
        override fun run(player:Player){
            if(!RecordUtils.value()){
                RecordUtils.cannotUse(player)
                return
            }
        }
    },
    RecordWard{
        override fun run(player:Player){
            if(!RecordUtils.value()){
                RecordUtils.cannotUse(player)
                return
            }
        }
    };

    open fun run(player: Player){
        TODO()
    }

}