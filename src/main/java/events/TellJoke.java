package events;

import Interfaces.CommandResponse;
import com.afrunt.randomjoke.Jokes;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class TellJoke implements CommandResponse{
    @Override
    public void doStuff(GuildMessageReceivedEvent event) {
        Jokes jokes = new Jokes().withDefaultSuppliers();
        jokes.randomJoke().ifPresent(joke -> event.getChannel().sendMessage(joke.getText()).queue());
    }
}
