package events;

import Interfaces.CommandResponse;
import JKMTells.JKMArrayStructure;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import java.util.ArrayList;
import java.util.Random;


public class KorwinQuote implements CommandResponse {
    @Override
    public void doStuff(GuildMessageReceivedEvent event) {
        StringBuilder quote = new StringBuilder();
        for (ArrayList<String> lista : JKMArrayStructure.getAll_Lists()) {
            quote.append(lista.get(new Random().nextInt(lista.size())));
            quote.append(" ");
        }
        event.getChannel().sendMessage(quote).queue();
    }
}
