package nl.kolkos.cryptowatcher.Models;

import lombok.Data;

@Data
public class TelegramChat {
    private long id;
    private boolean groupChat;
    private String title;

}
