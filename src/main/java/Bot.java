import Commands.BotCommand;
import events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;
import java.util.*;

public class Bot extends ListenerAdapter {
    private final String token = "";
    public JDA jda = JDABuilder.createDefault(token).build();
    private static Set<BotCommand> commands = new LinkedHashSet<>();

    public Bot() throws LoginException {
        jda.addEventListener(this); //JEDEN BY WSZYSTKIMI RZĄDZIC
        scheduleActivity();


        //Add commands, task
        commands.add(new BotCommand("help", new HelpInformation(),"Show help"));
        commands.add(new BotCommand("joke", new TellJoke(),"I can tell you some jokes"));
        commands.add(new BotCommand("korwin", new KorwinQuote(),"I can create random quoute of this famous Politician"));
        commands.add(new BotCommand("jp2", new PapaiDeathTime(),"I know how many days has passed since papai passed away"));
        commands.add(new BotCommand("ziobro", new Ziobro(),"Try it please"));
        commands.add(new BotCommand("pwr", new Pwr(),"Some truths about PWr"));
        commands.add(new BotCommand("code", new CodeSnippet(),"Some code from me"));
        commands.add(new BotCommand("me", new SenderInfo(),"Some info about you"));
        commands.add(new BotCommand("dev", new DevPlatform(),"Not for Users"));

        HelpInformation.sendCommandsToCreateHelp(commands);
    }


    //Status section--------------------------------------------------------------------------------

    String[] messages={"-help to start","Jebać W4","#najlepiejpwr","Java >> Wszystko inne",
            "***** ***","\uD83D\uDE0D Psy Tabakowa",
            "\uD83D\uDCAA\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC\uD83D\uDCAA\uD83C\uDFFC",
            "\uD83C\uDF51\uD83D\uDCA6\uD83C\uDF46"};
    int currentIndex=0;
    private void scheduleActivity(){
        //Schedule status change
        new Timer().schedule(new TimerTask(){
            public void run(){
                jda.getPresence().setActivity(Activity.playing(messages[currentIndex]));
                currentIndex=(currentIndex+1)%messages.length;
            }},0,3000);
    }

    //End of section status------------------------------------------------------------------------

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();
        BotCommand commandInvoked = getBotCommandByEvent(messageSent);
        if(commandInvoked!=null){
            commandInvoked.invokeMethod(event);
        }
    }


    public BotCommand getBotCommandByEvent(String msg){
        for (BotCommand cmd : commands) {
            if (cmd.getCommand().equals(msg)) {
                return cmd;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        new Bot();
    }
}
