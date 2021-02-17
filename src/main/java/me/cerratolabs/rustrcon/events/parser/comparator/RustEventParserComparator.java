package me.cerratolabs.rustrcon.events.parser.comparator;

import me.cerratolabs.rustrcon.events.messages.RustGenericMessage;

public interface RustEventParserComparator {

    boolean match(RustGenericMessage message);

}