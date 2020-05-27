package net.testusuke.hh.core.Config

import net.testusuke.hh.core.Main

class ModuleData(private val plugin: Main) {

    //  Data
    //  EnderPearl
    var enderPearlMode = true
    //  Record
    var recordMode = true
    var recordCoolTime:Int = 60
    //  Totem
    var totemMode = true
    //  BonusChest
    var bonusChestMode = true
    var bonusChestWorld = "world"
    var bonusChestValue = 5

    fun loadData(){

        //  config
        val config = plugin.config
        //  ender pearl
        val ender = "data.ender_pearl"
        enderPearlMode= config.getBoolean("${ender}.mode")
        //  Record
        val record = "data.record"
        recordMode = config.getBoolean("${record}.mode")
        recordCoolTime = config.getInt("${record}.cooltime")
        //  Totem
        val totem = "data.totem"
        totemMode = config.getBoolean("${totem}.mode")
        //  BonusChest
        val bonusChest = "data.bonuschest"
        bonusChestMode = config.getBoolean("${bonusChest}.mode")
        bonusChestWorld = config.getString("${bonusChest}.world") ?: "world"
        bonusChestValue = config.getInt("${bonusChest}.value")
    }
}