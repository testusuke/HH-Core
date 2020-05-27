package net.testusuke.hh.core.Ban.Command

import net.testusuke.hh.core.Main.Companion.prefix
import net.testusuke.hh.core.Permission
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object BanCommand:CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args : Array<out String>): Boolean {
        if(sender !is Player || !sender.hasPermission(Permission.admin))return false

        if(args.isEmpty()){
            sendHelp(sender)
            return true
        }

        when(args[0]){
            "help" -> sendHelp(sender)
            "on" -> changeMode(sender,true)
            "off" -> changeMode(sender,false)
            "unban" -> {
                if(args.size != 2){
                    sender.sendMessage("${prefix}§c使い方が不正です。")
                    sendHelp(sender)
                    return false
                }

            }
            "reload" -> reloadBanData(sender)
        }
        return false
    }
}