package events;

import Interfaces.CommandResponse;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Objects;

public class SenderInfo implements CommandResponse {
    @Override
    public void doStuff(GuildMessageReceivedEvent event) {
        StringBuilder stb = new StringBuilder();
        event.getChannel().sendMessage("*Information about U:*\n").queue();
        try {
            URL url = new URL(Objects.requireNonNull(event.getAuthor().getAvatarUrl()));
            BufferedImage img = ImageIO.read(url);
            File file = new File("avatar-"+event.getAuthor().getName()+".png");
            ImageIO.write(img, "png", file);
            event.getChannel().sendFile(new File("avatar-" + event.getAuthor().getName() + ".png")).queue();
        }catch (Exception e){
            event.getChannel().sendMessage("I have a problem with your avatar... Sorry").queue();
        }
        stb.append(event.getAuthor().getName()).append("#").append(event.getAuthor().getDiscriminator());
        event.getChannel().sendMessage(stb).queue();
    }
}
