package cn.edu.bupt.yaoxintong.events;

import org.neo4j.ogm.session.event.Event;

public class PostDeleteEvent extends ModificationEvent {

	public PostDeleteEvent(Event event) {
		super(event);
	}
}

