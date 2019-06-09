package nl.kolkos.cryptowatcher.models;

import lombok.Data;

@Data
public class TelegramUser {
    private long id;
    private boolean bot;
    private String firstName;
    private String lastName;
    private String username;
    private String languageCode;

}
