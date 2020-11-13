package events;

import Interfaces.CommandResponse;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Pwr implements CommandResponse {
    @Override
    public void doStuff(GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage("Zasady Politechniki Wrocławskiej:").queue();
        event.getChannel().sendMessage("1. Jebać W4").queue();
        event.getChannel().sendMessage("2. Lepiej chujem trzeć po żwirze niż studiować na AiRze").queue();
    }
}
