package cn.edu.bupt.yaoxintong.events;

import org.neo4j.ogm.session.event.Event;

public class PreDeleteEvent extends ModificationEvent {

	public PreDeleteEvent(Event event) {
		super(event);
	}
}
