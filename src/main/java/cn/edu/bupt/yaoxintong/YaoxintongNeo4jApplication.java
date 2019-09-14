package cn.edu.bupt.yaoxintong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import cn.edu.bupt.yaoxintong.events.EventPublisher;
import cn.edu.bupt.yaoxintong.events.PostSaveEvent;
import cn.edu.bupt.yaoxintong.events.PreDeleteEvent;
import cn.edu.bupt.yaoxintong.events.PreSaveEvent;

@SpringBootApplication
public class YaoxintongNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(YaoxintongNeo4jApplication.class, args);
	}

	/**
	 * Simply defining a Neo4j OGM <code>EventListener</code> will register it with
	 * the session factory.
	 */
	@Bean
	public EventPublisher eventPublisher() {
		return new EventPublisher();
	}

	@EventListener
	public void onPreSaveEvent(PreSaveEvent event) {
		Object entity = event.getSource();
		System.out.println("Before save of: " + entity);
	}

	@EventListener
	public void onPostSaveEvent(PostSaveEvent event) {
		Object entity = event.getSource();
		System.out.println("After save of: " + entity);
	}

	@EventListener
	public void onPreDeleteEvent(PreDeleteEvent event) {
		Object entity = event.getSource();
		System.out.println("Before delete of: " + entity);
	}
}
