package de.contania.test.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;
import java.text.MessageFormat;

/**
 * @author Espidia
 */
public class TestCommand implements CommandExecutor {

    private static final DecimalFormat HEALTH_FORMAT = new DecimalFormat("0.00");

    private final MessageFormat messageFormat;

    public TestCommand(String messagePattern) {
        this.messageFormat = new MessageFormat(messagePattern);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;
        String message = this.messageFormat.format(new Object[] {
            player.getName(),
            HEALTH_FORMAT.format(player.getHealth()),
            player.getLevel()}
        );

        player.sendMessage(message);
        return true;
    }
}
