package me.cerratolabs.rusrcon.events.parser.generic;

import me.cerratolabs.rusrcon.events.messages.RustGenericMessage;
import me.cerratolabs.rusrcon.events.parser.comparator.RustEventParserComparator;
import me.nurio.events.handler.Event;

public interface IParser<T extends Event> extends RustEventParserComparator {

    T toEvent(RustGenericMessage message);

}