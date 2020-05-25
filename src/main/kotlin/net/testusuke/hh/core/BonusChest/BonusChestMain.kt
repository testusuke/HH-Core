package net.testusuke.hh.core.BonusChest

import net.testusuke.hh.core.Main

class BonusChestMain(main: Main) {
    init {
        //  Logger
        main.logger.info("Enable BonusChest Main Class")
        // Command
        main.getCommand("core bonuschest")?.setExecutor(BonusChestCommand)
        //  Event
        main.server.pluginManager.registerEvents(LoadNewChunk,main)
    }
}