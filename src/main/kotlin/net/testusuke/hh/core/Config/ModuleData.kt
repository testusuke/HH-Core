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
    }
}