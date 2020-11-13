package Commands;

import Interfaces.CommandResponse;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class BotCommand {

    final String prefix = "-";
    private String command;
    private String description;
    CommandResponse commandTask;

    public BotCommand(String command, CommandResponse task, String description) {
        this.command = command;
        commandTask = task;
        this.description = description;
    }

    //Event delegate
    public void invokeMethod(GuildMessageReceivedEvent event){
        commandTask.doStuff(event);
    }

    public String getCommand() {
        return prefix+command;
    }

    public String getDescription() {
        return description;
    }
}
