package Interfaces;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.net.MalformedURLException;
import java.text.ParseException;

public interface CommandResponse {
    void doStuff(GuildMessageReceivedEvent event);
}
