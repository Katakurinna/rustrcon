package me.cerratolabs.rustrcon.events.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.nurio.events.handler.Event;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageReceiveEvent extends Event {

    private RustGenericMessage data;

}