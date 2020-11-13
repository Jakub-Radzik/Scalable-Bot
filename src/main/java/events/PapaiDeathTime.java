package events;

import Interfaces.CommandResponse;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.text.ParseException;
import java.time.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class PapaiDeathTime implements CommandResponse{

    private String timeSincePapaiDeath() throws ParseException {
        LocalDate now_date = LocalDate.now();
        LocalTime now_time = LocalTime.now();
        LocalDateTime papai_death = LocalDateTime.of(2005,4,2,21,37);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date d1 = sdf.parse("02-04-2005 21:37:00");
        Date d2 = sdf.parse("".concat(String.valueOf(now_date.getDayOfMonth()+"-"+now_date.getMonthValue()+"-"+now_date.getYear()+" "+now_time.getHour()+":"+now_time.getMinute()+":00")));
        long difference_In_Time
                = d2.getTime() - d1.getTime();
        long difference_In_Seconds
                = (difference_In_Time
                / 1000)
                % 60;

        long difference_In_Minutes
                = (difference_In_Time
                / (1000 * 60))
                % 60;

        long difference_In_Hours
                = (difference_In_Time
                / (1000 * 60 * 60))
                % 24;

        long difference_In_Years
                = (difference_In_Time
                / (1000l * 60 * 60 * 24 * 365));

        long difference_In_Days
                = (difference_In_Time
                / (1000 * 60 * 60 * 24))
                % 365;



        return "Od śmierci papieża minęło: "
                + difference_In_Years
                + " lat, "
                + difference_In_Days
                + " dni, "
                + difference_In_Hours
                + " godzin, "
                + difference_In_Minutes
                + " minut";
    }

    @Override
    public void doStuff(GuildMessageReceivedEvent event){
        try{
            event.getChannel().sendMessage(timeSincePapaiDeath()).queue();
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}
