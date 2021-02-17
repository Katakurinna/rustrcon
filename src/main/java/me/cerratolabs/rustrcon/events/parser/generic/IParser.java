package me.cerratolabs.rustrcon.events.parser.generic;

import me.cerratolabs.rustrcon.events.messages.RustGenericMessage;
import me.cerratolabs.rustrcon.events.parser.comparator.RustEventParserComparator;
import me.nurio.events.handler.Event;

public interface IParser<T extends Event> extends RustEventParserComparator {

    T toEvent(RustGenericMessage message);

}