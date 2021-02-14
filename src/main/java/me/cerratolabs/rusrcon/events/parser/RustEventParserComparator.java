package me.cerratolabs.rusrcon.events.parser;

public interface RustEventParserComparator {

    boolean match(RustGenericMessage message);

}