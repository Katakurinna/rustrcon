package me.cerratolabs.rusrcon.events.parser.comparator;

import me.cerratolabs.rusrcon.events.messages.RustGenericMessage;

public interface RustEventParserComparator {

    boolean match(RustGenericMessage message);

}