package events;

import Interfaces.CommandResponse;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.apache.commons.io.IOUtils;

import javax.annotation.Nonnull;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

public class DevPlatform implements CommandResponse {
    @Override
    public void doStuff(GuildMessageReceivedEvent event){

//        event.getGuild().getMembers().forEach(member -> System.out.println(member.getNickname()));
        @Nonnull List<Member> members = event.getGuild().getMembers();
        members.forEach(member -> System.out.println(member.getNickname()));
//        assert mem != null;
//        mem.getRoles().forEach(System.out::println);
//        event.getAuthor().getFlags().forEach(userFlag -> stb.append(userFlag.getName()).append("\n"));


//        event.getChannel().sendMessage(stb).queue();
    }
}
