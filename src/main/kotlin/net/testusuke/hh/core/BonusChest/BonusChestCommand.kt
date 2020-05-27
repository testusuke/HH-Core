package net.testusuke.hh.core.BonusChest

import net.testusuke.hh.core.Permission
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object BonusChestCommand:CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender !is Player || !sender.hasPermission(Permission.admin))return false

        if(args.isEmpty()){
            sendHelp(sender)
            return true
        }


        return false
    }

    private fun sendHelp(player: Player){

    }
}