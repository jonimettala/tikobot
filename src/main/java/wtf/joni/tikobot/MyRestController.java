package wtf.joni.tikobot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @Autowired
    DiscordBot bot;

    @RequestMapping(value="/testmsg", method = RequestMethod.POST)
    public void msgDiscord(@RequestBody MyMessage message) {
        System.out.println(message);
        bot.sendMessage(message.getGuild(), message.getChannel(), message.getMessage());
    }
}
