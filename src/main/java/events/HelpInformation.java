package events;

import Commands.BotCommand;
import Interfaces.CommandResponse;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import java.io.File;
import java.util.Set;

public class HelpInformation implements CommandResponse {

    private static String help_info="";

    public static void sendCommandsToCreateHelp(Set<BotCommand> Commands) {
        for (BotCommand cmd: Commands) {
            help_info += "\uD83D\uDC49\uD83C\uDFFC *" + cmd.getCommand() + "* - **" + cmd.getDescription()+"**\n";
        }
    }

    @Override
    public void doStuff(GuildMessageReceivedEvent event){

        event.getChannel().sendFile(new File("java-logo.png")).queue();
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage("*Made in Java*").queue();
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(help_info).queue();

    }
}

