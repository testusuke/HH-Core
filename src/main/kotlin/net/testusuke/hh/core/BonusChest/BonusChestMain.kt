package net.testusuke.hh.core.BonusChest

import net.testusuke.hh.core.Config.Data.BonusChestData
import net.testusuke.hh.core.Main

class BonusChestMain(main: Main) {

    var bonusChestData:BonusChestData? = null

    init {
        //  Logger
        main.logger.info("Enable BonusChest Main Class")
        //  Config
        bonusChestData = BonusChestData(main)
        // Command
        main.getCommand("core bonuschest")?.setExecutor(BonusChestCommand)
        //  Event
        main.server.pluginManager.registerEvents(LoadNewChunk,main)
    }

    fun onDisable(){
        //  Config
        bonusChestData?.saveData()

    }
}