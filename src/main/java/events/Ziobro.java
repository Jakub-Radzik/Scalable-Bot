package events;

import Interfaces.CommandResponse;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Ziobro implements CommandResponse {
    @Override
    public void doStuff(GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage("Ziobro, kurwo jebana, przestań mi kurwo rodzinę prześladować, pedale pisowski w dupę jebany ty").queue();
    }
}
