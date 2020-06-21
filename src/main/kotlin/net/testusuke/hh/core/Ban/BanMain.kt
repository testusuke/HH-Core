package net.testusuke.hh.core.Ban

import net.testusuke.hh.core.Ban.Command.BanCommand
import net.testusuke.hh.core.Ban.DataBase.BanDataBase
import net.testusuke.hh.core.Ban.Listener.PlayerDieEvent
import net.testusuke.hh.core.Ban.Listener.PlayerLoginEvent
import net.testusuke.hh.core.Config.Data.BanConfig
import net.testusuke.hh.core.Main

class BanMain(main: Main) {

    companion object{
        lateinit var banMain:BanMain
    }
    var banData:BanDataBase? = null
    var banConfig:BanConfig? = null
    // mode
    var mode = true

    init{
        banMain = this
        //  class
        banData = BanDataBase(main)
        //  Event
        val pm = main.server.pluginManager
        pm.registerEvents(PlayerDieEvent,main)
        pm.registerEvents(PlayerLoginEvent,main)
        //  Command
        main.getCommand("core ban")?.setExecutor(BanCommand)
        //  loadMode
        banConfig = BanConfig(main,this)
        banConfig?.loadMode()
    }

    fun onDisable(){
        banConfig?.saveMode()

    }
}