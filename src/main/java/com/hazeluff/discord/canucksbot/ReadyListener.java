package com.hazeluff.discord.canucksbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hazeluff.discord.canucksbot.nhl.NHLGameScheduler;
import com.hazeluff.discord.canucksbot.nhl.NHLTeam;

import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.Status;

/**
 * Listens for the ReadyEvent and initializes the bot.
 * 
 * @author hazeluff
 *
 */
public class ReadyListener extends MessageSender {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadyListener.class);

	private NHLGameScheduler gameScheduler;

	public ReadyListener(IDiscordClient client) {
		super(client);
		gameScheduler = new NHLGameScheduler(client);
	}

	@EventSubscriber
	public void onReady(ReadyEvent event) {
		client.changeStatus(Status.game("hazeluff.com"));

		for (IGuild guild : client.getGuilds()) {
			NHLGameScheduler.subscribe(NHLTeam.VANCOUVER_CANUCKS, guild);
		}

		LOGGER.info("Waiting for NHLGameScheduler to be ready.");
		while (!gameScheduler.isReady()) {
			LOGGER.trace("Waiting for NHLGameScheduler to be ready.");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gameScheduler.start();
	}
}