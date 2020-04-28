package com.hazeluff.discord.canucks.bot.database;

import com.hazeluff.discord.canucks.Config;
import com.hazeluff.discord.canucks.bot.database.fuck.FucksData;
import com.hazeluff.discord.canucks.bot.database.pole.PollsData;
import com.hazeluff.discord.canucks.bot.database.predictions.PredictionsData;
import com.hazeluff.discord.canucks.bot.database.predictions.results.ResultsData;
import com.hazeluff.discord.canucks.bot.database.preferences.PreferencesData;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * This class is used to manage preferences of Guilds and Users. Preferences are stored in MongoDB.
 */
public class PersistentData {
	private final MongoDatabase database;

	private final PreferencesData preferencesData;
	private final FucksData fucksData;
	private final PollsData polesData;
	private final ResultsData resultsData;
	private final PredictionsData predictionsData;


	PersistentData(MongoDatabase database, PreferencesData preferencesData, FucksData fucksData, PollsData polesData,
			ResultsData resultsData, PredictionsData predictionsData) {
		this.database = database;
		this.preferencesData = preferencesData;
		this.fucksData = fucksData;
		this.polesData = polesData;
		this.resultsData = resultsData;
		this.predictionsData = predictionsData;
	}

	public static PersistentData load() {
		return load(getDatabase());
	}

	static PersistentData load(MongoDatabase database) {
		PreferencesData preferencesManager = PreferencesData.load(database);
		FucksData fucksManager = FucksData.load(database);
		PollsData polesManager = PollsData.load(database);
		ResultsData resultsManager = ResultsData.load(database);
		PredictionsData predictionsManager = PredictionsData.load(database);
		return new PersistentData(database, preferencesManager, fucksManager, polesManager, resultsManager,
				predictionsManager);
	}

	@SuppressWarnings("resource")
	private static MongoDatabase getDatabase() {
		return new MongoClient(Config.MONGO_HOST, Config.MONGO_PORT)
				.getDatabase(Config.MONGO_DATABASE_NAME);
	}

	public PreferencesData getPreferencesData() {
		return preferencesData;
	}

	public FucksData getFucksData() {
		return fucksData;
	}

	public PollsData getPolesData() {
		return polesData;
	}

	public ResultsData getResultsData() {
		return resultsData;
	}

	public PredictionsData getPredictionsData() {
		return predictionsData;
	}

	public MongoDatabase getMongoDatabase() {
		return database;
	}

}
