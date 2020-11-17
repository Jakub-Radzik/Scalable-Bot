package events;

import Interfaces.CommandResponse;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.Objects;

public class ServerInfo implements CommandResponse {
    @Override
    public void doStuff(GuildMessageReceivedEvent event) {

        StringBuilder sb = new StringBuilder();
        sb.append("SERVER INFO\n").append(event.getGuild().getName());

        sb.append(event.getGuild().getOwner().getNickname());

        for (int i = 0; i < event.getGuild().getRoles().size(); i++) {
            String role = event.getGuild().getRoles().get(i).getName();
            if(!role.equals("@everyone")) {
                sb.append(role).append("\n");
            }
        }
        event.getChannel().sendMessage(sb).queue();
    }
}
