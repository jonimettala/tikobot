package wtf.joni.tikobot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class Bot implements DiscordBot {

    private String SECRET_TOKEN = "";
    private JDA jda;

    public Bot() {
        try {
            jda = new JDABuilder(AccountType.BOT)
                    .setToken(SECRET_TOKEN)
                    .setGame(Game.watching("cute cat videos"))
                    .setStatus(OnlineStatus.DO_NOT_DISTURB)
                    .addEventListener(new MyBotListener())
                    .buildBlocking();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String guild, String channel, String message) {
        try {
            jda
                    .getGuildById(guild)
                    .getTextChannelById(channel)
                    .sendMessage(message)
                    .queue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
