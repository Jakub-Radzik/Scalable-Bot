package events;

import Interfaces.CommandResponse;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CodeSnippet implements CommandResponse {
    @Override
    public void doStuff(GuildMessageReceivedEvent event) {
        String code = "```java\n@Override\n" +
                "    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {\n" +
                "        String messageSent = event.getMessage().getContentRaw();\n" +
                "        BotCommand commandInvoked = getBotCommandByEvent(messageSent);\n" +
                "        if(commandInvoked!=null){\n" +
                "            commandInvoked.invokeMethod(event);\n" +
                "        }\n" +
                "    }```";
        event.getChannel().sendMessage(code).queue();
    }
}
