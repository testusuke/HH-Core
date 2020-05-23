package net.testusuke.hh.core

import net.testusuke.hh.core.Command.CoreCommand
import net.testusuke.hh.core.Config.ModuleData
import net.testusuke.hh.core.Listener.*
import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin

class Main:JavaPlugin() {

    companion object{
        //  Plugin
        lateinit var plugin:Main
        //  Prefix
        val prefix = "§e[§cHH§f-§aCore§e]§f"
        //  Mode
        var mode = true
        //  ConfigData
        lateinit var moduleData: ModuleData

    }
    override fun onEnable() {
        plugin = this
        //  Config
        this.saveDefaultConfig()
        loadMode()
        //  Command
        getCommand("core")?.setExecutor(CoreCommand)
        //  Event
        val pm = server.pluginManager
        pm.registerEvents(EnderPearlUseEvent,this)
        pm.registerEvents(RecordEvent,this)
        pm.registerEvents(DrinkMilkEvent,this)
        pm.registerEvents(WitherEffectEvent,this)
        pm.registerEvents(ActivateTotem,this)
        //  Load class
        moduleData = ModuleData(this)
        moduleData.loadData()

    }

    override fun onDisable() {
        saveMode()
    }

    fun loadMode(){
        mode = try{
            config.getBoolean("mode")
        }catch (e:NullPointerException){
            e.printStackTrace()
            true
        }
    }

    fun saveMode(){
        config.set("mode",mode)
        saveConfig()
    }
}