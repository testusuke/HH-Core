package net.testusuke.hh.core

import net.testusuke.hh.core.Ban.BanMain
import net.testusuke.hh.core.BonusChest.BonusChestMain
import net.testusuke.hh.core.Command.CoreCommand
import net.testusuke.hh.core.Config.ModuleData
import net.testusuke.hh.core.Listener.*
import org.bukkit.plugin.java.JavaPlugin
import javax.xml.crypto.Data

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

    //  Class
    //  DB
    lateinit var dataBase:DataBase
    //  BonusChest
    lateinit var bonusChest:BonusChestMain
    //  Ban
    lateinit var banMain:BanMain


    override fun onEnable() {
        plugin = this
        //  Config
        this.saveDefaultConfig()
        loadMode()
        //  DB
        dataBase = DataBase(prefix)

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
        //  config
        moduleData = ModuleData(this)
        moduleData.loadData()
        //  BonusChest
        bonusChest = BonusChestMain(this)
        //  Ban
        banMain = BanMain(this)

    }

    override fun onDisable() {
        saveMode()
        //  Class
        bonusChest.onDisable()
        
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