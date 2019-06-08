package nl.kolkos.cryptowatcher.Models;

import lombok.Data;

import java.util.Date;

@Data
public class TelegramMessage {
    private long id;
    private boolean command;
    private boolean reply;
    private long messageId;
    private Date date;
    private String text;
    private int status;

    private TelegramUser telegramUser;
    private TelegramChat telegramChat;

}
