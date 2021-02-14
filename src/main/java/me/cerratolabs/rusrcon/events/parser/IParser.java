package me.cerratolabs.rusrcon.events.parser;

import me.nurio.events.handler.Event;

public interface IParser<T extends Event> extends RustEventParserComparator {

    T toEvent(RustGenericMessage message);

}