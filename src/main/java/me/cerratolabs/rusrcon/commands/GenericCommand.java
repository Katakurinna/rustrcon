package me.cerratolabs.rusrcon.commands;

import lombok.Data;

import java.util.Map;

@Data
public class GenericCommand {

    /**
     * The message must begin with the words. It will work in both global chat and team chat
     */
    private String messageContains;

    /**
     * Will send this command to the server, it can be used <code>;</code> to send various commands.
     */
    private String playCommand;

    /**
     * Saves the default time that has to elapse for the user to use it, after having used it previously
     */
    private Long timeoutPerPlayer;

    /**
     * It is used to know the level of permissions that the user needs to reproduce them. By default everyone is level 0.
     */
    private Integer needAuthorization;

    /**
     * Saves the user who has run it and how long it needs to pass until you can run it again
     */
    private Map<String, Long> timeoutCounter;

}