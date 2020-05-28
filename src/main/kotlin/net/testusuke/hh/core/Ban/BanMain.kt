package net.testusuke.hh.core.Ban

import net.testusuke.hh.core.Ban.Command.BanCommand
import net.testusuke.hh.core.Ban.DataBase.BanData
import net.testusuke.hh.core.Ban.Listener.PlayerDieEvent
import net.testusuke.hh.core.Ban.Listener.PlayerLoginEvent
import net.testusuke.hh.core.Main
import org.bukkit.event.player.PlayerJoinEvent

class BanMain(main: Main) {

    var banData:BanData? = null
    // mode
    var mode = true

    init {

        //  class
        banData = BanData(main)
        //  Event
        val pm = main.server.pluginManager
        pm.registerEvents(PlayerDieEvent,main)
        pm.registerEvents(PlayerLoginEvent,main)
        //  Command
        main.getCommand("core ban")?.setExecutor(BanCommand)
        //  loadMode
        loadMode()
    }
}