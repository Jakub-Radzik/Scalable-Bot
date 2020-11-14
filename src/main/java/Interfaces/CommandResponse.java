package Interfaces;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public interface CommandResponse {
    void doStuff(GuildMessageReceivedEvent event);
}
