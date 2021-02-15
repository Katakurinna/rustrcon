package me.cerratolabs.rusrcon.events.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.cerratolabs.rusrcon.events.messages.RustGenericMessage;
import me.nurio.events.handler.Event;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageReceiveEvent extends Event {

    private RustGenericMessage data;

}